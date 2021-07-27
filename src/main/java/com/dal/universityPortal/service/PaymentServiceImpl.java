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
    public void savePayment(Payment payment){
        try {
            String status = "";
            System.out.println("1111");
            CardValidator cardValidator = new CardValidator();
            if (cardValidator.isValid(payment.getCardNumber())) {
                System.out.println("222");
                status = PaymentDAO.fetchStatus(payment.getApplication_id());
                if (status.equals("Pending")) {
                    PaymentDAO.updateStatus(payment);
                    PaymentDAO.insertPayment(payment);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
