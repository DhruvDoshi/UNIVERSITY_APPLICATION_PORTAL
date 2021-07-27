package com.dal.universityPortal.validator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SpecialCharacterPresentValidatorTest {
    String stringWithSpecialChar = "a@";
    String stringWithNoSpecialChar = "aa";
    String expectedErrorMessage = "Special character is not present.";
    SpecialCharacterPresentValidator validator = new SpecialCharacterPresentValidator();

    @Test
    void isValidWithStringWithSpecialChar_returnsTrue() {
        assertTrue(validator.isValid(stringWithSpecialChar));
    }

    @Test
    void isValidWithStringWithNoSpecialChar_returnsFalse() {
        assertFalse(validator.isValid(stringWithNoSpecialChar));
    }

    @Test
    void getErrorMessage_returnsErrorMessage() {
        assertEquals(expectedErrorMessage, validator.getErrorMessage());
    }
}
