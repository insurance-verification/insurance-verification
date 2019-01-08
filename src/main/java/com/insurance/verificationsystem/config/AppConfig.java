package com.insurance.verificationsystem.config;

import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;

import java.io.File;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.ehcache.Cache;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.ExpiryPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.insurance.verificationsystem.cache.CacheValuesProvider;
import com.insurance.verificationsystem.cache.LastUpdatedTimeProvider;
import com.insurance.verificationsystem.cache.PolicyNumbers;
import com.insurance.verificationsystem.cache.Vehicle;
import com.insurance.verificationsystem.cache.VehicleRepository;
import com.insurance.verificationsystem.cache.VehiclesCacheLoader;
import com.insurance.verificationsystem.listener.CronCacheReloader;
import com.insurance.verificationsystem.listener.StartUpCacheLoader;
import com.insurance.verificationsystem.service.VehicleValidationService;
import com.insurance.verificationsystem.service.VehicleVerificationService;
import com.zaxxer.hikari.HikariDataSource;

@EnableScheduling
@Configuration
public class AppConfig {

    @Value("${verificationsystem.cache.vehicles.heap_mb:10}")
    private Integer vehiclesHeapMb;

    @Value("${verificationsystem.cache.vehicles.disk_mb:100}")
    private Integer vehiclesDiskMb;

    @Value("${verificationsystem.cache.policies.heap_mb:10}")
    private Integer policiesHeapMb;

    @Value("${verificationsystem.cache.policies.disk_mb:100}")
    private Integer policiesDiskMb;

    @Value("${verificationsystem.cache.storage_path:cache}")
    private String storagePath;

    // @Value("${verificationsystem.db.table-name}")
    // private String tableName;
    @Value("${verificationsystem.db.vehicle-count-query:}")
    private String vehicleCountQuery;
    @Value("${verificationsystem.db.vehicle-query:}")
    private String vehicleQuery;
    @Value("${verificationsystem.db.datasource.hikari.connection-test-query:}")
    private String connectionTestQuery;

    @Value("${verificationsystem.db.read-batch-size:0}")
    private Integer batchSize;

    @Value("${verificationsystem.reload.on-start-up:false}")
    private boolean loadOnStartUp;

    @Bean(destroyMethod = "close")
    public PersistentCacheManager cacheManager() {
        final PersistentCacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(storagePath + File.separator + "vehicles"))
                .withCache("lastUpdatedTime",
                        newCacheConfigurationBuilder(String.class, LocalDateTime.class,
                                ResourcePoolsBuilder.newResourcePoolsBuilder().heap(1, EntryUnit.ENTRIES).disk(1,
                                        MemoryUnit.MB, true)).withExpiry(ExpiryPolicy.NO_EXPIRY))
                .withCache("vehicles",
                        newCacheConfigurationBuilder(String.class,
                                Vehicle.class, ResourcePoolsBuilder.newResourcePoolsBuilder()
                                        .heap(vehiclesHeapMb, MemoryUnit.MB).disk(vehiclesDiskMb, MemoryUnit.MB, true))
                                                .withExpiry(ExpiryPolicy.NO_EXPIRY)

                ).withCache("policies", newCacheConfigurationBuilder(String.class, PolicyNumbers.class, ResourcePoolsBuilder.newResourcePoolsBuilder().heap(policiesHeapMb, MemoryUnit.MB).disk(policiesDiskMb, MemoryUnit.MB, true)).withExpiry(ExpiryPolicy.NO_EXPIRY)).build(true);
        final Cache<String, LocalDateTime> lastUpdatedTime = cacheManager.getCache("lastUpdatedTime", String.class,
                LocalDateTime.class);
        return cacheManager;
    }

    @Bean
    @Primary
    @ConfigurationProperties("verificationsystem.db.datasource")
    public DataSourceProperties vehiclesDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        final DataSource retval = vehiclesDataSourceProperties().initializeDataSourceBuilder().build();
        // Support the connection test query
        // https://stackoverflow.com/questions/42247864/configure-hikaricp-in-spring-boot-with-jtds
        if (retval instanceof HikariDataSource && connectionTestQuery != null
                && connectionTestQuery.trim().length() > 0) {
            ((HikariDataSource) retval).setConnectionTestQuery(connectionTestQuery);
        }
        return retval;
    }

    @Bean
    @Primary
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public Cache<String, LocalDateTime> lastUpdatedTimeCache() {
        return cacheManager().getCache("lastUpdatedTime", String.class, LocalDateTime.class);
    }

    @Bean
    public Cache<String, Vehicle> vehiclesCache() {
        return cacheManager().getCache("vehicles", String.class, Vehicle.class);
    }

    @Bean
    public Cache<String, PolicyNumbers> policiesCache() {
        return cacheManager().getCache("policies", String.class, PolicyNumbers.class);
    }

    @Bean
    public CacheValuesProvider<Vehicle> vehicleCacheValuesProvider() {
        return new VehicleRepository(jdbcTemplate(), vehicleQuery, vehicleCountQuery, batchSize);
    }

    @Bean
    public LastUpdatedTimeProvider lastUpdatedTimeProvider() {
        return new LastUpdatedTimeProvider(lastUpdatedTimeCache());
    }

    @Bean
    public VehiclesCacheLoader cacheLoader(final Cache<String, Vehicle> vehiclesCache,
            final Cache<String, PolicyNumbers> policiesCache,
            final CacheValuesProvider<Vehicle> vehicleCacheValuesProvider) {
        return new VehiclesCacheLoader(vehiclesCache, policiesCache, vehicleCacheValuesProvider,
                lastUpdatedTimeProvider());
    }

    @Bean
    public VehicleValidationService vehicleValidationService() {
        return new VehicleValidationService(vehiclesCache(), policiesCache());
    }

    @Bean
    public VehicleVerificationService vehicleVerificationService() {
        return new VehicleVerificationService(vehicleValidationService());
    }

    @Bean
    public CronCacheReloader cronCacheReloader(final VehiclesCacheLoader vehicleCacheLoader) {
        return new CronCacheReloader(vehicleCacheLoader);
    }

    @Bean
    public StartUpCacheLoader startUpCacheLoader(final VehiclesCacheLoader vehicleCacheLoader) {
        return new StartUpCacheLoader(vehicleCacheLoader, loadOnStartUp);
    }
}
