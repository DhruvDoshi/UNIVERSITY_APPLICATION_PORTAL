package com.dal.universityPortal.service;

import com.dal.universityPortal.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class ModelValidatorServiceTest {

    private static final String INVALID_INTEGER = "Invalid Integer";
    @Mock
    Validator<String> stringValidator;

    @Mock
    Validator<Integer> integerValidator;

    ModelValidatorService modelValidatorService = new ModelValidatorService();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnTrueIfValidatorsReturnTrue() {
        Mockito.when(stringValidator.isValid(any())).thenReturn(true);
        Mockito.when(integerValidator.isValid(any())).thenReturn(true);

        assertTrue(modelValidatorService.isValid(getFieldValueMap()));

    }

    @Test
    void shouldReturnTrueIfAnyValidatorsReturnFalse() {
        Mockito.when(stringValidator.isValid(any())).thenReturn(true);
        Mockito.when(integerValidator.isValid(any())).thenReturn(false);
        Mockito.when(integerValidator.getErrorMessage()).thenReturn(INVALID_INTEGER);

        assertFalse(modelValidatorService.isValid(getFieldValueMap()));
        String errorMessage = modelValidatorService.getErrorMessages().get(0);
        assertTrue(errorMessage.contains(INVALID_INTEGER));

    }

    private Map<Object, Validator> getFieldValueMap() {
        Map<Object, Validator> validatorMap = new HashMap<>();
        validatorMap.put("String value", stringValidator);
        validatorMap.put(1, integerValidator);
        return validatorMap;
    }

}