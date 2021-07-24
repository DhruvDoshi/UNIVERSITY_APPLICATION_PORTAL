package com.dal.universityPortal.model;

import com.dal.universityPortal.service.ModelValidatorService;
import com.dal.universityPortal.validator.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ValidatedModel {
    protected ModelValidatorService validator;
    private List<FieldValidator> fieldValueMapping= new ArrayList<>();

    ValidatedModel(ModelValidatorService validator) {
        this.validator = validator;
    }

    List<FieldValidator> getFieldValidatorMapping() {
        return new ArrayList<>();
    }

    public boolean isValid() {
        return validator.isValid(fieldValueMapping);
    }

    public List<String> getErrorMessages() {
        return validator.getErrorMessages();
    }
}