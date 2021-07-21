package com.dal.universityPortal.service;

import com.dal.universityPortal.database.PaymentDAO;
import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.database.DBSession;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public Boolean savePayment(Payment payment) throws SQLException {
        try {
            String status = "";
            PaymentDAO.foreignKeysSet();
            PaymentDAO.insertCards(payment);
            status = PaymentDAO.fetchStatus(payment.getApplication_id());
            if (status == "PENDING"){
                PaymentDAO.updateStatus(payment);
                PaymentDAO.insertPayment(payment);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

}
