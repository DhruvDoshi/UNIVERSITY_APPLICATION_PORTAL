package com.dal.universityPortal.service;

import com.dal.universityPortal.database.ApplicationStatusDao;
import com.dal.universityPortal.database.ReviewApplicationDao;
import com.dal.universityPortal.database.UniversityDao;
import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.model.University;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ApplicationStatusServiceImpl implements ApplicationStatusService {

    ApplicationStatusDao applicationStatusDao = new ApplicationStatusDao();
    ReviewApplicationDao reviewApplicationDao = new ReviewApplicationDao();
    UniversityDao universityDao = new UniversityDao();

    @Override
    public Application getApplicationDetails(int id) throws SQLException {
        Application application = new Application();
        application = reviewApplicationDao.fetchAllByParam(id);
        return application;
    }

    @Override
    public Program getProgramDetails(int id) throws SQLException {
      return applicationStatusDao.fetchAllByParam(id);
    }

    @Override
    public University getUniversityDetails(int id) throws SQLException {
        List<University> universityList = universityDao.fetchAll();
        University universityDetails = new University();
        for (University university : universityList) {
            if (university.getUserId() == id) {
                universityDetails.setUniversityName(university.getUniversityName());
            }
        }
        return universityDetails;
    }
}
