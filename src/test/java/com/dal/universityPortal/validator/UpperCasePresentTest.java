package com.dal.universityPortal.validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UpperCasePresentTest {
    String stringWithUpperCase = "Aa";
    String stringWithoutUpperCase = "aa";
    String stringWithSpecialCharacter = "@a";
    String expectedErrorMessage = "Uppercase is not present in the string.";
    UpperCasePresent validator = new UpperCasePresent();

    @Test
    void isValidWithStringWithUpperCase_returnsTrue() {
        assertTrue(validator.isValid(stringWithUpperCase));
    }

    @Test
    void isValidWithStringWithLowerCase_returnsFalse() {
        assertFalse(validator.isValid(stringWithoutUpperCase));
    }

    @Test
    void isValidWithStringWithSpecialChar_returnsFalse() {
        assertFalse(validator.isValid(stringWithSpecialCharacter));
    }

    @Test
    void getErrorMessage_returnsErrorMessage() {
        assertEquals(expectedErrorMessage, validator.getErrorMessage());
    }
}
