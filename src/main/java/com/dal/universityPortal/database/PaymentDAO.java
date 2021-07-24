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
    public static String fetchStatus(int application_id) throws SQLException{
        List<Map<String, Object>> row;
        try(DBSession dbSession = new DBSession()) {
            row = dbSession.fetch(FETCH_STATUS_APPLICATION_ID, Arrays.asList(application_id));
            return (String) row.get(0).get("status");
        }
    }

    public static void foreignKeysSet() throws SQLException {
        try (DBSession dbSession = new DBSession()) {
            dbSession.execute(FOREIGN_KEY_CHECKS);
        }
    }

    @Override
    public void insert(Payment payment) throws SQLException {

    }

    public static void insertPayment(Payment payment) throws SQLException{
        try (DBSession dbSession = new DBSession()){
            dbSession.execute(INSERT_INTO_PAYMENTS, Arrays.asList(payment.getApplication_id(),payment.getCardNumber(), payment.getAmount()));
            dbSession.execute(UPDATE_STATUS_PAYMENTS, Arrays.asList(payment.getApplication_id()));
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
