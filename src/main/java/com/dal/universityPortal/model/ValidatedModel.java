package com.dal.universityPortal.model;

import com.dal.universityPortal.service.ModelValidatorService;
import com.dal.universityPortal.validator.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ValidatedModel {
    protected ModelValidatorService validator;
    private Map<Object, Validator> fieldValueMapping= new HashMap<>();

    ValidatedModel(ModelValidatorService validator) {
        this.validator = validator;
    }

    Map<Object, Validator> getFieldValidatorMapping() {
        return new HashMap<>();
    }

    public boolean isValid() {
        return validator.isValid(fieldValueMapping);
    }

    public List<String> getErrorMessages() {
        return validator.getErrorMessages();
    }
}