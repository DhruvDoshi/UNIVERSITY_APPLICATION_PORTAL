package com.dal.universityPortal.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharacterPresentValidator implements Validator<String> {

    public SpecialCharacterPresentValidator() {}

    @Override
    public boolean isValid(String string) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    @Override
    public String getErrorMessage() {
        return "Special character is not present."; //TODO: Move to constants.
    }
}
