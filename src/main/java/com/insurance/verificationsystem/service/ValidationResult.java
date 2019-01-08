package com.insurance.verificationsystem.service;

import java.util.Optional;

public class ValidationResult {

    private final String oldCode;
    private final String newCode;

    public ValidationResult(String oldCode, String newCode) {
        this.oldCode = oldCode;
        this.newCode = newCode;
    }

    public Optional<String> getOldCode() {
        return Optional.ofNullable(oldCode);
    }

    public Optional<String> getNewCode() {
        return Optional.ofNullable(newCode);
    }

    @Override
    public String toString() {
        return "ValidationResult [" +
                "oldCode = " + oldCode +
                ", newCode = " + newCode +
                "]";
    }
}
