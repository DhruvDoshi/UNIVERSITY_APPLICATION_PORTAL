package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Payment;
import java.sql.SQLException;

public interface PaymentService {
    Boolean savePayment (Payment payment) throws SQLException;
}
