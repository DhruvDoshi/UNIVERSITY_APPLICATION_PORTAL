package com.dal.universityPortal.service;

import com.dal.universityPortal.database.DashboardDao;
import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.Dashboard;
import com.dal.universityPortal.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class DashboardServiceImpl implements DashboardService{

    @Autowired
    DashboardDao dashboardDao;

    @Override
    public void displayInformation(Dashboard dashboard) throws SQLException {

    }

    @Override
    public List<Application> readListApplication(int student_id) throws SQLException {
        return dashboardDao.fetchApplication(student_id);

    }

    @Override
    public List<Payment> readListPayment(int student_id) throws SQLException {
        return dashboardDao.fetchPayment(student_id);
    }

//    @Override
//    public List<Payment> readList() throws SQLException {
//        return DashboardDao.fetchAll();
//
//    }
}
