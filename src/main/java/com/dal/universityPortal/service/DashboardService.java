package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.Dashboard;
import com.dal.universityPortal.model.Payment;
import java.sql.SQLException;
import java.util.List;

public interface DashboardService {

    void displayInformation(Dashboard dashboard) throws SQLException;
        List<Application> readListApplication(int student_id) throws SQLException;
        List<Payment> readListPayment(int student_id) throws SQLException;
}
