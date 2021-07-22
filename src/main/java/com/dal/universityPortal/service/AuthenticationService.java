package com.dal.universityPortal.service;

import com.dal.universityPortal.exceptions.UnsupportedUser;
import com.dal.universityPortal.model.Credential;
import com.dal.universityPortal.model.User;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public interface AuthenticationService {
    void login(HttpSession session, Credential credential) throws SQLException, UnsupportedUser;
    void logout(HttpSession session);
    User getCurrentUser(HttpSession session);
}
