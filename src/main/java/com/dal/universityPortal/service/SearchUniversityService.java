package com.dal.universityPortal.service;

import com.dal.universityPortal.model.UniversityProfile;

import java.sql.SQLException;

public interface SearchUniversityService {

   UniversityProfile getUniversityDetails(UniversityProfile universityProfile) throws SQLException;
}
