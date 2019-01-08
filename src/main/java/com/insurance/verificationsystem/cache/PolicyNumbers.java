package com.insurance.verificationsystem.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PolicyNumbers implements Serializable {

    private List<String> policyNumbers = new ArrayList<>();

    public List<String> getPolicyNumbers() {
        return policyNumbers;
    }
}
