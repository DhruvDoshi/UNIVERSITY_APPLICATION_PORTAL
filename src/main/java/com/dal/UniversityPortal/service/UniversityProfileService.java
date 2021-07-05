package com.dal.UniversityPortal.service;

import com.dal.UniversityPortal.model.university_profile;


public interface UniversityProfileService {
    void saveUniversityProfile(university_profile university_profile);
    university_profile getUniversityProfileById(int id);
}
