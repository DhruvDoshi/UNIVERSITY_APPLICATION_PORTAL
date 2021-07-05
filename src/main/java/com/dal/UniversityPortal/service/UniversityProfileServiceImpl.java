package com.dal.UniversityPortal.service;

import com.dal.UniversityPortal.model.university_profile;
import com.dal.UniversityPortal.repository.UniversityProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniversityProfileServiceImpl implements UniversityProfileService {
    @Autowired
    private UniversityProfileRepository universityProfileRepository;
    @Override
    public void saveUniversityProfile(university_profile university_profile) {
        this.universityProfileRepository.save(university_profile);
    }

    @Override
    public university_profile getUniversityProfileById(int id) {
        Optional< university_profile > optional = universityProfileRepository.findById(id);
        university_profile university_profile = null;
        if (optional.isPresent()) {
            university_profile = optional.get();
        } else {
            throw new RuntimeException(" University not found for id :: " + id);
        }
        return university_profile;
    }
}
