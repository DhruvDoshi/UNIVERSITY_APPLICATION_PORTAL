package com.dal.universityPortal.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AdminPanelService {
    List <Map<String, Object> > getPendingStatusUniversities() throws SQLException;
    boolean allowUniversityById(int id) throws SQLException;
    boolean denyUniversityById(int id) throws SQLException;

}

