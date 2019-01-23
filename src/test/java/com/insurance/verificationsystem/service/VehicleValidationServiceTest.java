package com.insurance.verificationsystem.service;

import com.insurance.verificationsystem.cache.PolicyNumbers;
import com.insurance.verificationsystem.cache.Vehicle;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.insurance.verificationsystem.cache.VehiclesCacheLoaderTest.create;
import static org.ehcache.config.builders.CacheConfigurationBuilder.newCacheConfigurationBuilder;
import static org.ehcache.config.builders.ResourcePoolsBuilder.heap;

public class VehicleValidationServiceTest {

    private VehicleValidationService validator;

    @Before
    public void init() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("vehicles",
                        newCacheConfigurationBuilder(String.class, Vehicle.class, heap(10)))
                .withCache("policies",
                        newCacheConfigurationBuilder(String.class, PolicyNumbers.class, heap(10)))
                .build();
        cacheManager.init();

        Cache<String, Vehicle> vehicles = cacheManager.getCache("vehicles", String.class, Vehicle.class);
        Cache<String, PolicyNumbers> policies = cacheManager.getCache("policies", String.class, PolicyNumbers.class);

        Vehicle v1 = create(1, "p1", "v1");
        v1.setEffectiveDate(LocalDateTime.of(2018, 1 , 1, 0, 0, 0));
        v1.setExpireDate(LocalDateTime.of(2019, 1 , 1, 0, 0, 0));

        vehicles.put(v1.getPolicyNumber(), v1);
        PolicyNumbers pn = new PolicyNumbers();
        pn.getPolicyNumbers().add(v1.getPolicyNumber());
        policies.put(v1.getVin(), pn);

        validator = new VehicleValidationService(vehicles, policies);
    }

    @Test
    public void policy_key_not_submitted() {

    }

    public static void assertError(List<ValidationResult> result, String oldCode, String newCode) {
        if(result.stream().noneMatch(r ->
                        Objects.equals(Optional.ofNullable(newCode), r.getNewCode()) &&
                        Objects.equals(Optional.ofNullable(oldCode), r.getOldCode()))) {
            Assert.fail();
        }
    }

    @Test
    public void vin_not_submitted() {
        assertError(validator.validate(new VehicleInfo()), "4", "VIN4");
    }

    @Test
    public void verification_date_not_submitted() {
        assertError(validator.validate(new VehicleInfo()), "5", "VDT2");
    }

    @Test
    public void system_cannot_locate_policy_key_information() {
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setPolicyNumber("Z");
        assertError(validator.validate(vehicleInfo), "7", "PKEY2");
    }

    @Test
    public void system_cannot_locate_vin() {
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setVin("Z");
        assertError(validator.validate(vehicleInfo), null, "VIN1");
    }

    @Test
    public void coverage_on_verification_date_cannot_be_confirmed() {
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setPolicyNumber("v1");
        vehicleInfo.setVin("p1");
        vehicleInfo.setVerificationDate(LocalDateTime.of(2017, 1, 1, 1, 1));
        assertError(validator.validate(vehicleInfo), "8", "PKEY3");
    }

    @Test
    public void vin_cannot_be_verified() {
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setPolicyNumber("v1");
        vehicleInfo.setVin("Z");
        assertError(validator.validate(vehicleInfo), "9", "PKEY4");
    }

    @Test
    public void policy_key_cannot_be_verified() {
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setPolicyNumber("z1");
        vehicleInfo.setVin("p1");
        assertError(validator.validate(vehicleInfo), "10", "VIN3");

    }

}
