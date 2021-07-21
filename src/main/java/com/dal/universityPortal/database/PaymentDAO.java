package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Payment;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dal.universityPortal.database.query.PaymentQuery.*;

@Component
public class PaymentDAO implements Dao<Payment>{


    @Override
    public List<Payment> fetchAll() throws SQLException {
        return null;
    }
    public static String fetchStatus(String application_id) throws SQLException{
        List<Map<String, Object>> status;
        try(DBSession dbSession = new DBSession()) {
            status = dbSession.fetch(FETCH_STATUS_APPLICATION_ID, Arrays.asList(application_id));
            if(status.contains("PENDING")){
                return "PENDING";
            }
        }
        return "";
    }

    public static void foreignKeysSet() throws SQLException {
        try (DBSession dbSession = new DBSession()) {
            dbSession.execute(FOREIGN_KEY_CHECKS);
        }
    }

    @Override
    public void insert(Payment payment) throws SQLException {

    }

    public static void insertCards(Payment payment) throws SQLException {
        try (DBSession dbSession = new DBSession()){
            dbSession.execute(INSERT_CARD_DETAILS, Arrays.asList(payment.getName(), payment.getCardNumber(), payment.getExpiryDate(), payment.getCVV()));
        }
    }

    public static void insertPayment(Payment payment) throws SQLException{
        try (DBSession dbSession = new DBSession()){
            dbSession.execute(INSERT_INTO_PAYMENTS, Arrays.asList(payment.getApplication_id(),payment.getCardNumber()));
        }
    }

    @Override
    public void update(Payment payment) throws SQLException {

    }

    public static void updateStatus (Payment payment) throws SQLException {
        try (DBSession dbSession = new DBSession()) {
            dbSession.execute(UPDATE_STATUS_APPLICATION_ID, Arrays.asList(payment.getApplication_id()));
        }
    }
    @Override
    public void delete(Payment payment) throws SQLException {

    }
}
