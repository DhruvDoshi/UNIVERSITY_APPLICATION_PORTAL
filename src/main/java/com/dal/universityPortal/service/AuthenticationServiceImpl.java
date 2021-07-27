package com.dal.universityPortal.service;

import com.dal.universityPortal.database.UserDao;
import com.dal.universityPortal.email.Sendmail;
import com.dal.universityPortal.exceptions.UnsupportedUser;
import com.dal.universityPortal.exceptions.ValidationException;
import com.dal.universityPortal.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Random;

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

    @Override
    public void sendPasswordCode(String username) throws SQLException, UnsupportedUser {
        User user = userDao.fetchOne(username);
        if(isNull(user)){
            throw new UnsupportedUser();
        }
        Integer randomCode = new Random().nextInt(999999);
        Sendmail mailClient = new Sendmail(user.getEmail(), "Reset Password Code", String.format("The password reset code is: %s", randomCode));
        try{
            mailClient.sendMail();
        } catch (MessagingException exception) {
            System.out.println("Mail Exception");
        }
        userDao.setResetCode(user, randomCode);
    }

    @Override
    public void resetPassword(ResetCredential resetCredential) throws SQLException, ValidationException {
        User user = userDao.fetchOne(resetCredential.getUsername());
        if(isNull(user) || !user.getResetCode().equals(resetCredential.getResetCode())) {
            throw new ValidationException("The credentials doesn't match");
        }
        user.setPassword(resetCredential.getPassword());
        if(!user.isValid()) {
            throw new ValidationException(user.getErrorMessages());
        }
        userDao.update(user);
    }

    @Override
    public String getRedirectLink(UserType type) {
        String handle = type.equals(UserType.STAFF) ? UserType.UNIVERSITY.toString() : type.toString();
        return String.format("/%s/dashboard", handle.toLowerCase());
        //return String.format("/%s/dashboard", type.toString().toLowerCase());
    }
}
