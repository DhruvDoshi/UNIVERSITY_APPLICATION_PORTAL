package com.dal.universityPortal.service;

import com.dal.universityPortal.database.DBSession;
import com.dal.universityPortal.database.ProgramDao;
import com.dal.universityPortal.database.UniversityDao;
import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.model.University;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class UniversityProfileServiceImpl implements UniversityProfileService {
    UniversityDao universityDao = new UniversityDao();

    @Override
    public Boolean saveProfile(University university) throws SQLException {
        try {
            universityDao.insert(university);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    @Override
    public University readProfile(int id) throws SQLException {
        University university = new University();
        List<University> universityList = universityDao.fetchAll();
        for (int i = 0; i < universityList.size(); i++) {
            if (universityList.get(i).getUserId() == id) {
                university.setUserId(universityList.get(i).getUserId());
                university.setUniversityName(universityList.get(i).getUniversityName());
                university.setUniversityDescription(universityList.get(i).getUniversityDescription());
            }
        }
        return university;
    }

    @Override
    public Boolean updateProfile(University university) throws SQLException {
        universityDao.update(university);
        return true;
    }

}
