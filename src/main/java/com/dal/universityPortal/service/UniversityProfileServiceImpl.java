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
public class UniversityProfileServiceImpl implements UniversityProfileService{
    UniversityDao universityDao= new UniversityDao();
    @Override
    public Boolean saveProfile(University university) throws SQLException {
        try {
            if(university.getUniversityName().isEmpty()){
                universityDao.insert(university);
            }else{
                // Update
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return true;
    }

}
