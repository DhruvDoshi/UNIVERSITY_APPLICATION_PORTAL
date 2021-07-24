package com.dal.universityPortal.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.dal.universityPortal.constant.UserConstant.PASSWORD_MIN_LENGTH;
import static com.dal.universityPortal.constant.UserConstant.USERNAME_MIN_LENGTH;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final String MIN_LENGTH_ERROR = "The min length should be ";
    private static final String UPPERCASE_ERROR = "Uppercase is not present in the string.";
    private static final String SPECIAL_CHAR_ERROR = "Special character is not present.";
    private static final String email = "e@e.com";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void returnTrue_whenUserIsValid() {
        User user = new User("username", email, "Asdfghj@12", UserType.ADMIN);

        final boolean valid = user.isValid();
        final List<String> errorMessages = user.getErrorMessages();

        assertTrue(valid);
        assertTrue(errorMessages.isEmpty());
    }

    @Test
    void returnFalse_whenUsernameIsInValid() {
        User user = new User("us", email, "Asdfghj@12", UserType.ADMIN);

        final boolean valid = user.isValid();
        final String errorMessage = user.getErrorMessages().get(0);

        assertFalse(valid);
        assertTrue(errorMessage.contains(MIN_LENGTH_ERROR+USERNAME_MIN_LENGTH));
    }

    @Test
    void returnFalse_whenPasswordIsInValidUpperCase() {
        User user = new User("username", email, "asdfghj@12", UserType.ADMIN);

        final boolean valid = user.isValid();
        final String errorMessage = user.getErrorMessages().get(0);

        assertFalse(valid);
        assertTrue(errorMessage.contains(UPPERCASE_ERROR));
    }

    @Test
    void returnFalse_whenPasswordIsInValidMinLength() {
        User user = new User("username", "email", "Pass", UserType.ADMIN);

        final boolean valid = user.isValid();
        final String errorMessage = user.getErrorMessages().get(0);

        assertFalse(valid);
        assertTrue(errorMessage.contains(MIN_LENGTH_ERROR+PASSWORD_MIN_LENGTH));
    }

    @Test
    void returnFalse_whenPasswordIsInSpecial() {
        User user = new User("username", "email", "Password", UserType.ADMIN);

        final boolean valid = user.isValid();
        final String errorMessage = user.getErrorMessages().get(0);

        assertFalse(valid);
        assertTrue(errorMessage.contains(SPECIAL_CHAR_ERROR));
    }

}