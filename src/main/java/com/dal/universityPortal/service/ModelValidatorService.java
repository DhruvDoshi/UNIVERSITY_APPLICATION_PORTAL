package com.dal.universityPortal.service;



import com.dal.universityPortal.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelValidatorService {

    private List<String> errorMessages;

    public boolean isValid(Map<Object, Validator> fieldValueMapping) {
        errorMessages = new ArrayList<>();
        fieldValueMapping.forEach((value, validator) -> {
            if (!validator.isValid(value)) {
                this.errorMessages.add(value+": "+validator.getErrorMessage());
            }
        });
        return this.errorMessages.isEmpty();
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}