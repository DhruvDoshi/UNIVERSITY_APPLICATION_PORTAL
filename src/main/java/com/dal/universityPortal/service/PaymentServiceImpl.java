package com.dal.universityPortal.service;

import com.dal.universityPortal.database.PaymentDAO;
import com.dal.universityPortal.email.Sendmail;
import com.dal.universityPortal.exceptions.ValidationException;
import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.validator.CardValidator;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public void savePayment(Payment payment) throws SQLException {
        try {
            String status = "";
            CardValidator cardValidator = new CardValidator();
            if (!cardValidator.isValid(payment.getCardNumber())){
                throw new ValidationException();
            }
            status = PaymentDAO.fetchStatus(payment.getApplication_id());
            if (status.equals("PENDING")) {
                PaymentDAO.updateStatus(payment);
                PaymentDAO.insertPayment(payment);
                new Sendmail(payment.getEmail(), "PAYMENT DONE SUCCESSFULLY", "THE PAYMENT IS COMPLETED", "https://imgur.com/a/uQrSS6W");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
