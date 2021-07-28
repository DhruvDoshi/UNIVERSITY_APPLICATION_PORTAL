package com.dal.universityPortal.constant;

public class RegexConstant {
    public static final String SPECIAL_CHAR_PRESENT_REGEX = "[^A-Za-z0-9]";
    public static final String EMAIL_REGEX="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
}
