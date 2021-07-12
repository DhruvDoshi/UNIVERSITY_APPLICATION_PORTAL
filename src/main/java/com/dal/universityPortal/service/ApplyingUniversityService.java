package com.dal.universityPortal.service;


import java.sql.SQLException;

import com.dal.universityPortal.model.Application;


public interface ApplyingUniversityService {
    void saveApplication(Application application) throws SQLException;
    
}
