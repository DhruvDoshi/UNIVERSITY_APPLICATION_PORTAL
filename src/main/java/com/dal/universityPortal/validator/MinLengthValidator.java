package com.dal.universityPortal.validator;

public class MinLengthValidator implements Validator<String> {

    Integer minLength;

    public MinLengthValidator(Integer minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean isValid(String string) {
        return minLength <= string.length();
    }

    @Override
    public String getErrorMessage() {
        return "The min length should be "+ minLength; //TODO: Move to constants
    }
}
