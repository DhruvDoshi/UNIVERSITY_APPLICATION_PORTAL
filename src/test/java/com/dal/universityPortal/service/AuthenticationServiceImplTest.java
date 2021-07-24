package com.dal.universityPortal.service;

import com.dal.universityPortal.database.UserDao;
import com.dal.universityPortal.exceptions.UnsupportedUser;
import com.dal.universityPortal.exceptions.ValidationException;
import com.dal.universityPortal.model.Credential;
import com.dal.universityPortal.model.ResetCredential;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.model.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;


import javax.servlet.http.HttpSession;
import java.sql.SQLException;

import static com.dal.universityPortal.model.UserType.STUDENT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;


class AuthenticationServiceImplTest {

    @Mock
    UserDao userDao;

    @Mock
    User user;

    @Mock
    ResetCredential resetCredential;

    @Mock
    HttpSession httpSession;

    @InjectMocks
    AuthenticationServiceImpl authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldLogin() throws SQLException, UnsupportedUser {
        User user = new User("user", "user@email.com", "pass", STUDENT);
        user.setStatus(UserStatus.ACTIVE);
        Mockito.when(userDao.fetchOne(any())).thenReturn(user);
        Credential credential = new Credential();
        credential.setUsername("user");
        credential.setPassword("pass");
        authenticationService.login(httpSession, credential);

        Mockito.verify(httpSession).setAttribute("user", user);
    }

    @Test
    void shouldThrowExceptionWhenStatusIsPendingInLogin() throws SQLException, UnsupportedUser {
        User user = new User("user", "user@email.com", "pass", STUDENT);
        user.setStatus(UserStatus.PENDING);
        Mockito.when(userDao.fetchOne(any())).thenReturn(user);
        Credential credential = new Credential();
        credential.setUsername("user");
        credential.setPassword("pass");
        assertThrows(UnsupportedUser.class, () -> authenticationService.login(httpSession, credential));

        Mockito.verify(httpSession, Mockito.times(0)).setAttribute("user", user);
    }

    @Test
    void shouldThrowExceptionWhenPasswordDoesnotMatchInLogin() throws SQLException, UnsupportedUser {
        User user = new User("user", "user@email.com", "pass", STUDENT);
        user.setStatus(UserStatus.ACTIVE);
        Mockito.when(userDao.fetchOne(any())).thenReturn(user);
        Credential credential = new Credential();
        credential.setUsername("user");
        credential.setPassword("passsssssss");
        assertThrows(UnsupportedUser.class, () -> authenticationService.login(httpSession, credential));

        Mockito.verify(httpSession, Mockito.times(0)).setAttribute(anyString(), any());
    }

    @Test
    void shouldThrowExceptionWhenUserDoesnotExistInLogin() throws SQLException, UnsupportedUser {
        Mockito.when(userDao.fetchOne(any())).thenReturn(null);
        Credential credential = new Credential();
        credential.setUsername("user");
        credential.setPassword("pass");
        assertThrows(UnsupportedUser.class, () -> authenticationService.login(httpSession, credential));

        Mockito.verify(httpSession, Mockito.times(0)).setAttribute(anyString(), any());
    }

    @Test
    void shouldLogout() {
        authenticationService.logout(httpSession);

        Mockito.verify(httpSession).removeAttribute("user");
    }

    @Test
    void sendPasswordCode() throws SQLException, UnsupportedUser {
        Mockito.when(userDao.fetchOne(any())).thenReturn(user);
        authenticationService.sendPasswordCode("testUser");
        Mockito.verify(userDao).setResetCode(any(User.class), anyInt());
    }

    @Test
    void sendPasswordCodeThrowsExceptionWhenWrongUsername() throws SQLException, UnsupportedUser {
        Mockito.when(userDao.fetchOne(any())).thenReturn(null);
        assertThrows(UnsupportedUser.class, () -> authenticationService.sendPasswordCode("testUser"));
    }

    @Test
    void resetPassword() throws SQLException, ValidationException {
        Mockito.when(userDao.fetchOne(any())).thenReturn(user);
        Mockito.when(user.isValid()).thenReturn(true);
        Mockito.when(user.getResetCode()).thenReturn(1);
        Mockito.when(resetCredential.getResetCode()).thenReturn(1);
        authenticationService.resetPassword(resetCredential);
        Mockito.verify(userDao).update(any(User.class));
    }
    //TODO: passwordReset test
}