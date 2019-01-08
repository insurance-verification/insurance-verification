package com.insurance.verificationsystem.service;

import java.util.Optional;

public enum WsdlVersion {
    OLD {
        @Override
        public Optional<String> getCode(ValidationResult validationResult) {
            return validationResult.getOldCode();
        }
    }, NEW {
        @Override
        public Optional<String> getCode(ValidationResult validationResult) {
            return validationResult.getNewCode();
        }
    };

    public static WsdlVersion defineVersion(String publicationVersion) {
        if(publicationVersion == null) {
            return WsdlVersion.NEW;
        }
        return publicationVersion.compareTo("00200706") >= 0
                ? WsdlVersion.NEW
                : WsdlVersion.OLD;
    }

    public abstract Optional<String> getCode(ValidationResult validationResult);

}
