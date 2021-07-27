package com.dal.universityPortal.validator;

import java.util.Arrays;

public class UpperCasePresent implements Validator<String> {
    @Override
    public boolean isValid(String string) {
        return string.chars().anyMatch(Character::isUpperCase);
    }

    @Override
    public String getErrorMessage() {
        return "Uppercase is not present in the string."; //TODO: Move to a constant
    }
}
