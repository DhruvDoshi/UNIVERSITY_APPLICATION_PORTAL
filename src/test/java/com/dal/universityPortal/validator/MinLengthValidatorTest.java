package com.dal.universityPortal.validator;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class MinLengthValidatorTest {
    String shortString = "aa";
    String longString = "aaaaaa";
    String noString = "";
    Integer minLength = 3;
    MinLengthValidator validator = new MinLengthValidator(minLength);
    String expectedErrorFormat = "The min length should be %s";

    @Test
    void stringWithoutMinLength_returnsFalse() {
        assertFalse(validator.isValid(shortString));
    }

    @Test
    void stringWithMinLength_returnsTrue() {
        assertTrue(validator.isValid(longString));
    }

    @Test
    void stringWithNoLength_returnsFalse() {
        assertFalse(validator.isValid(noString));
    }

    @Test
    void getErrorMessage_returnsErrorMessage() {
        assertEquals(String.format(expectedErrorFormat, minLength),
                validator.getErrorMessage());
    }

}
