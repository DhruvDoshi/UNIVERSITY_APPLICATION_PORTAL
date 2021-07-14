package com.dal.universityPortal.service;

import com.dal.universityPortal.model.AdminPanel;

import java.sql.SQLException;
import java.util.List;

public interface AdminPanelService {
    List<AdminPanel> getPendingStatusUniversities() throws SQLException;
    boolean allowUniversityById(AdminPanel adminPanel) throws SQLException;
    boolean denyUniversityById(AdminPanel adminPanel) throws SQLException;

}

