package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.Payment;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dal.universityPortal.database.query.DashboardQuery.APPLICATIONS_FROM_STUDENT_ID;
import static com.dal.universityPortal.database.query.DashboardQuery.PAYMENT_FROM_STUDENT_ID;

@Service
public class DashboardDao {

    //TODO: Dhruv - Move this to payment
    public List<Payment> fetchPayment(int student_id) throws SQLException {
        List<Map<String, Object>> paymentList;
        List<Payment> payments = new ArrayList<>();
        try (DBSession dbSession = new DBSession()) {
            paymentList = dbSession.fetch(PAYMENT_FROM_STUDENT_ID, Arrays.asList(student_id));
            for (Map<String, Object> mapApplication : paymentList) {
                Payment payment = new Payment();
                payment.setApplication_id(Integer.parseInt(String.valueOf(mapApplication.get("application_id"))));
                payment.setAmount(Integer.parseInt(String.valueOf(mapApplication.get("amount"))));
                payments.add(payment);
            }
        }
        return payments;
    }

    //TODO: Dhruv - Move this to application
    public List<Application> fetchApplication(int student_id) throws SQLException {
        List<Map<String, Object>> applicationList;
        List<Application> applications = new ArrayList<>();
        try (DBSession dbSession = new DBSession()) {
            applicationList = dbSession.fetch(APPLICATIONS_FROM_STUDENT_ID, Arrays.asList(student_id));
            for (Map<String, Object> mapApplication : applicationList) {
                Application application = new Application();
                application.setApplication_id(Integer.parseInt(String.valueOf(mapApplication.get("id"))));
                application.setStatus(String.valueOf(mapApplication.get("status")));
                applications.add(application);
            }
        }
        return applications;
    }

}
