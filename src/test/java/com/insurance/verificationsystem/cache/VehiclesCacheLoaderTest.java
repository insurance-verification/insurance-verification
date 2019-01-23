package com.insurance.verificationsystem.cache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.junit.Before;
import org.junit.Test;

import java.security.Policy;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;
import static org.junit.Assert.*;

public class VehiclesCacheLoaderTest {

    private Cache<String, Vehicle> vehicles;
    private Cache<String, PolicyNumbers> policies;

    private LastUpdatedTimeProvider lastUpdatedTimeProvider;

    @Before
    public void init() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("vehicles",
                        newCacheConfigurationBuilder(String.class, Vehicle.class, heap(10)))
                .withCache("policies",
                        newCacheConfigurationBuilder(String.class, PolicyNumbers.class, heap(10)))
                .withCache("lastUpdatedTimeProvider",
                        newCacheConfigurationBuilder(String.class, LocalDateTime.class, heap(10)))
                .build();
        cacheManager.init();

        lastUpdatedTimeProvider = new LastUpdatedTimeProvider(cacheManager.getCache("lastUpdatedTimeProvider", String.class, LocalDateTime.class));
        vehicles = cacheManager.getCache("vehicles", String.class, Vehicle.class);
        policies = cacheManager.getCache("policies", String.class, PolicyNumbers.class);
    }

    @Test
    public void reload() {
        Vehicle v1 = create(1, "p1", "v1");
        Vehicle v2 = create(2, "p2", "v2");
        Vehicle v3 = create(3, "p3", "v3");

        VehiclesCacheLoader vehiclesCacheLoader =
                new VehiclesCacheLoader(vehicles, policies, new ArrayCacheValuesProvider<>(v1, v2, v3), lastUpdatedTimeProvider);
        
        vehiclesCacheLoader.reload();
        
        assertTrue(vehicles.containsKey("v1"));
        assertTrue(vehicles.containsKey("v2"));
        assertTrue(vehicles.containsKey("v3"));

        assertTrue(policies.containsKey("p1"));
        assertTrue(policies.containsKey("p2"));
        assertTrue(policies.containsKey("p3"));

        assertEquals(v1,vehicles.get("v1"));
    }

    @Test
    public void reloadWithRemove() {
        Vehicle v1 = create(1, "p1", "v1");
        v1.setRemoved(true);

        vehicles.put("p1", v1);
        PolicyNumbers pn = new PolicyNumbers();
        pn.getPolicyNumbers().add("p1");
        policies.put("v1", pn);

        VehiclesCacheLoader vehiclesCacheLoader =
                new VehiclesCacheLoader(vehicles, policies, new ArrayCacheValuesProvider<>(v1), lastUpdatedTimeProvider);
        vehiclesCacheLoader.reload();
        
        assertFalse(vehicles.containsKey("p2"));
        assertFalse(policies.containsKey("v2"));
    }

    public static Vehicle create(Integer id, String policyNumber, String vin) {
        Vehicle v = new Vehicle();
        v.setId(id);
        v.setPolicyNumber(policyNumber);
        v.setVin(vin);
        v.setRemoved(false);
        return v;
    }

    public static class ArrayCacheValuesProvider<T> implements CacheValuesProvider<T> {
        private List<T> elements;
        public ArrayCacheValuesProvider(T ... elements) {
            this.elements = Arrays.asList(elements);
        }
        @Override
        public Iterator<List<T>> getValues() {
            return Collections.singletonList(elements).iterator();
        }
    }


}
