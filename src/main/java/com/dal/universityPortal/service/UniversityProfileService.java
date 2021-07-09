package com.dal.universityPortal.service;

import com.dal.universityPortal.model.UniversityProfile;

import java.sql.SQLException;


public interface UniversityProfileService {
    void saveProfile(UniversityProfile universityProfile) throws SQLException;

}
