package com.dal.universityPortal.service;

import com.dal.universityPortal.database.AdminDao;
import com.dal.universityPortal.model.AdminPanel;
import com.dal.universityPortal.model.UserStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AdminPanelServiceImpl implements AdminPanelService{

    AdminDao adminDao = new AdminDao();

    @Override
    public List<AdminPanel> getPendingStatusUniversities() throws SQLException {
        List<AdminPanel> listUniversities = adminDao.fetchAll();
        return listUniversities;
    }

    @Override
    public boolean allowUniversityById(AdminPanel adminPanel) {
        adminPanel.setStatus(UserStatus.ACTIVE.toString());
        adminDao.update(adminPanel);
        return true;
    }

    @Override
    public boolean denyUniversityById(AdminPanel adminPanel) {
        adminPanel.setStatus(UserStatus.BLOCKED.toString());
        adminDao.update(adminPanel);
        return true;
    }
}
