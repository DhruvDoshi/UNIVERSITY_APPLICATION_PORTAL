package com.dal.universityPortal.service;

import com.dal.universityPortal.database.UserDao;
import com.dal.universityPortal.exceptions.UnsupportedUser;
import com.dal.universityPortal.model.Credential;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

import static java.util.Objects.isNull;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private UserDao userDao;

    @Override
    public void login(HttpSession session, Credential credential) throws SQLException, UnsupportedUser {
        User user = userDao.fetchOne(credential.getUsername());
        if(isNull(user) || !isSupportedUser(credential.getPassword(), user)) {
            throw new UnsupportedUser();
        }
        session.setAttribute("user", user);
    }

    private boolean isSupportedUser(String password, User user) {
        return password.equals(user.getPassword()) && user.getStatus().equals(UserStatus.ACTIVE);
    }

    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }

    @Override
    public User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("user"); //TODO: Write Test
    }
}
