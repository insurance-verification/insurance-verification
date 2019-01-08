package com.insurance.verificationsystem.cache;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Vehicle implements Serializable {

    private Integer id;

    private String policyNumber;

    private LocalDateTime effectiveDate;

    private LocalDateTime expireDate;

    private String vin;

    private Boolean removed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Boolean isRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, policyNumber, effectiveDate, expireDate, removed);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle that = (Vehicle) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.vin, that.vin) &&
               Objects.equals(this.policyNumber, that.policyNumber) &&
               Objects.equals(this.effectiveDate, that.effectiveDate) &&
               Objects.equals(this.expireDate, that.expireDate) &&
               Objects.equals(this.removed, that.removed);
    }

    @Override
    public String toString() {
        return "Vehicle [" +
                "id = " + id +
                ", vin = " + vin +
                ", policyNumber = " + policyNumber +
                ", effectiveDate = " + effectiveDate +
                ", expireDate = " + expireDate +
                ", removed = " + removed +
                "]";
    }
}
