package com.insurance.verificationsystem.service;

import com.insurance.verificationsystem.cache.PolicyNumbers;
import com.insurance.verificationsystem.cache.Vehicle;
import org.ehcache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class VehicleValidationService {
    private static final Logger logger = LoggerFactory.getLogger(VehicleValidationService.class);

    private final Cache<String, Vehicle> vehiclesCache;
    private final Cache<String, PolicyNumbers> policiesCache;
    @Value("${verificationsystem.response.future-days:-1}")
    private Integer futureDays;
    @Value("${verificationsystem.response.past-days:-1}")
    private Integer pastDays;

    public VehicleValidationService(Cache<String, Vehicle> vehiclesCache, Cache<String, PolicyNumbers> policiesCache) {
        this.vehiclesCache = requireNonNull(vehiclesCache);
        this.policiesCache = requireNonNull(policiesCache);
    }

    public List<ValidationResult> validate(VehicleInfo vehicleInfo) {
        try {
            return doValidate(vehicleInfo);
        } catch (Exception e) {
            logger.error("Error when checking coverage", e);
            return singletonList(new ValidationResult("12", "SYSU"));
        }
    }

    private List<ValidationResult> doValidate(VehicleInfo vehicleInfo) {
        Optional<Vehicle> vehicle = vehicleInfo.getVin() == null
                ? Optional.empty()
                : Optional.ofNullable(vehiclesCache.get(vehicleInfo.getVin()));
        if(vehicle.isPresent()) {
            logger.info("Vehicle found by VIN: " + vehicle.get().toString());
        } else {
            logger.info("Vehicle not found by VIN");
        }
        Optional<PolicyNumbers> policyNumbers = vehicleInfo.getPolicyNumber() == null
                ? Optional.empty()
                : Optional.ofNullable(policiesCache.get(vehicleInfo.getPolicyNumber()));
        if(policyNumbers.isPresent()) {
            logger.info("Policy found.");
        } else {
            logger.info("Policy not found.");
        }
        return validate(vehicleInfo, vehicle, policyNumbers);
    }

    private List<ValidationResult> validate(VehicleInfo vehicleInfo, Optional<Vehicle> vehicle, Optional<PolicyNumbers> policyNumbers) {
        List<ValidationResult> results = new ArrayList<>();
        // Policy Key Not Submitted
        boolean hasPolicyNumber = vehicleInfo.getPolicyNumber() != null && !vehicleInfo.getPolicyNumber().isEmpty();
        if(!hasPolicyNumber) {
            results.add(new ValidationResult("2", "PKEY1"));
        }
        // VIN Not Submitted
        boolean hasVin = vehicleInfo.getVin() != null && !vehicleInfo.getVin().isEmpty();
        if(!hasVin) {
            results.add(new ValidationResult("4", "VIN4"));
        }
        // Verification Date Not Submitted
        boolean hasVerificationDate = vehicleInfo.getVerificationDate() != null;
        if(!hasVerificationDate) {
            results.add(new ValidationResult("5", "VDT2"));
        }
        // System Cannot Locate Policy Key Information
        boolean locateVehicle = hasPolicyNumber && policyNumbers.isPresent();
        if(!locateVehicle) {
            results.add(new ValidationResult("7", "PKEY2"));
        }

        // System Cannot Locate VIN
        boolean locateVin = hasVin && vehicle.isPresent();
        if(!locateVin) {
            results.add(new ValidationResult(null, "VIN1"));
        }

        // System Found Policy Key - Coverage on Verification Date Cannot Be Confirmed
        if(locateVehicle && hasVerificationDate) {
            Vehicle v = vehicle.get();
            boolean dateConfirmed = v.getEffectiveDate().isBefore(vehicleInfo.getVerificationDate()) &&
                    v.getExpireDate().isAfter(vehicleInfo.getVerificationDate()) && isInWindow(vehicleInfo.getVerificationDate());
            if(!dateConfirmed) {
                results.add(new ValidationResult("8", "PKEY3"));
            }
        }
        // System Found Policy Key - VIN Cannot Be Verified
        if(locateVehicle && hasVin) {
            Vehicle v = vehicle.get();
            boolean vinVerified = vehicleInfo.getVin().equals(v.getVin());
            if(!vinVerified) {
                results.add(new ValidationResult("9", "PKEY4"));
            }
        }
        // System Found VIN - Policy Key Cannot Be Verified
        if(hasVin && locateVin && !locateVehicle) {
            results.add(new ValidationResult("10", "VIN3"));
        }
        return results;
    }
/**
 * Regardless of the data set, do not validate queries outside the configured window
 * @param queryTime
 * @return
 */
    private boolean isInWindow(LocalDateTime queryTime) {
        if(futureDays>=0){
            Calendar notAfter = Calendar.getInstance();
            notAfter.add(Calendar.DAY_OF_YEAR, futureDays);
            notAfter.add(Calendar.HOUR, 8);
            if(queryTime.compareTo(toLocalDateTime(notAfter))>0){
                return false;
            }
        }
        if(pastDays>=0){
            Calendar notBefore = Calendar.getInstance();
            notBefore.add(Calendar.DAY_OF_YEAR, -1 * pastDays);
            if(queryTime.compareTo(toLocalDateTime(notBefore))<0){
                return false;
            }
        }
        return true;
    }
    
    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        TimeZone tz = calendar.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        return LocalDateTime.ofInstant(calendar.toInstant(), zid);
    }

}
