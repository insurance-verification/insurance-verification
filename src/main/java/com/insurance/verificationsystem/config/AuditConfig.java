package com.insurance.verificationsystem.config;

import com.insurance.verificationsystem.audit.AuditRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AuditConfig {

    @Value("${verificationsystem.audit.response-table-name}")
    private String auditResponseTableName;

    @Value("${verificationsystem.audit.request-table-name}")
    private String auditRequestTableName;

    @Bean
    @ConfigurationProperties("verificationsystem.audit.datasource")
    public DataSourceProperties auditDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource auditDataSource() {
        return auditDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean("AuditSource")
    public JdbcTemplate auditJdbcTemplate() {
        return new JdbcTemplate(auditDataSource());
    }

    @Bean
    public AuditRepository auditRepository(@Qualifier("AuditSource") JdbcTemplate auditJdbcTemplate) {
        return new AuditRepository(auditJdbcTemplate, auditRequestTableName, auditResponseTableName);
    }

//    @Bean
//    @ConfigurationProperties(prefix = "verificationsystem.audit.datasource.liquibase")
//    public LiquibaseProperties auditLiquibaseProperties() {
//        return new LiquibaseProperties();
//    }
//
//    @Bean
//    public SpringLiquibase auditLiquibase() {
//        return springLiquibase(auditDataSource(), auditLiquibaseProperties());
//    }
//
//    private static SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setDataSource(dataSource);
//        liquibase.setChangeLog(properties.getChangeLog());
//        liquibase.setContexts(properties.getContexts());
//        liquibase.setDefaultSchema(properties.getDefaultSchema());
//        liquibase.setDropFirst(properties.isDropFirst());
//        liquibase.setShouldRun(properties.isEnabled());
//        liquibase.setLabels(properties.getLabels());
//        liquibase.setChangeLogParameters(properties.getParameters());
//        liquibase.setRollbackFile(properties.getRollbackFile());
//        return liquibase;
//    }
}
