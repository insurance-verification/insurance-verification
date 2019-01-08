package com.insurance.verificationsystem.service;

import java.time.LocalDateTime;

public class VehicleInfo {

    private String vin;

    private String policyNumber;

    private LocalDateTime verificationDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDateTime getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDateTime verificationDate) {
        this.verificationDate = verificationDate;
    }

    @Override
    public String toString() {
        return "VehicleInfo [" +
                "vin = " + vin +
                ", policyNumber = " + policyNumber +
                ", verificationDate = " + verificationDate +
                "]";
    }
}
