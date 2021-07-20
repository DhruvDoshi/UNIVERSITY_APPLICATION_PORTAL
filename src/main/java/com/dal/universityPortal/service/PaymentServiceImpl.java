package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.database.DBSession;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public void savePayment(Payment payment) throws SQLException {
        try(DBSession dbSession = new DBSession();) {
            int application_id = 1;
            dbSession.execute("SET FOREIGN_KEY_CHECKS=OFF;");
            dbSession.execute("INSERT INTO allcards(name, cardNumber, expiryDate, CVV) VALUES (?,?,?,?)", Arrays.asList(payment.getName(), payment.getCardNumber(), payment.getExpiryDate(), payment.getCVV()));
        }
    }
}
