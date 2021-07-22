package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Payment;

import java.sql.SQLException;

public interface CardValidatorService {
    Boolean isValid (Payment payment) throws SQLException;
}
