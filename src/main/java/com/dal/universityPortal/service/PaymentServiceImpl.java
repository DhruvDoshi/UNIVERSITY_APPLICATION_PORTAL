package com.dal.universityPortal.service;

import com.dal.universityPortal.database.PaymentDAO;
import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.database.DBSession;
import com.dal.universityPortal.model.UserStatus;
import com.dal.universityPortal.model.UserType;
import com.dal.universityPortal.validator.CardValidator;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public void savePayment(Payment payment) throws SQLException {
        try {
            String status = "";
            CardValidator cardValidator = new CardValidator();
            if (cardValidator.isValid(payment.getCardNumber())) {
                status = PaymentDAO.fetchStatus(payment.getApplication_id());
                if (status.equals("PENDING")) {
                    PaymentDAO.updateStatus(payment);
                    PaymentDAO.insertPayment(payment);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
