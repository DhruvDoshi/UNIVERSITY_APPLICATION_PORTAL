package com.dal.UniversityPortal.repository;

import com.dal.UniversityPortal.model.university_profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityProfileRepository extends JpaRepository<university_profile, Integer> {
}
