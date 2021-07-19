package com.dal.universityPortal.service;

import com.dal.universityPortal.database.UserDao;
import com.dal.universityPortal.exceptions.ValidationException;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.model.UserStatus;
import com.dal.universityPortal.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) throws SQLException, ValidationException {
        List<String> errorMessages = new ArrayList<>();
        if(user.isValid()) {
            UserStatus userStatus = user.getTypeEnum().equals(UserType.STUDENT) ? UserStatus.ACTIVE : UserStatus.PENDING;
            user.setStatus(userStatus);
            try {
                userDao.insert(user);
            } catch (SQLIntegrityConstraintViolationException exception) {
                errorMessages.add("User already exists");
                throw new ValidationException(errorMessages);
            }
        } else {
            errorMessages.addAll(user.getErrorMessages());
            throw new ValidationException(errorMessages);
        }
    }
}