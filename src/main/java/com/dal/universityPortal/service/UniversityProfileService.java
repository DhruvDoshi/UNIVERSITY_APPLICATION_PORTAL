package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.model.University;

import java.sql.SQLException;


public interface UniversityProfileService {
    Boolean saveProfile(University university) throws SQLException;

}
