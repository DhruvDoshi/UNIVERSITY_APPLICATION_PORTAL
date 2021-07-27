package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.Program;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface ApplicationService {
    Boolean saveApplication(Application application) throws SQLException;
    Application readApplication(int id) throws SQLException;
}
