package com.dal.universityPortal.service;

import com.dal.universityPortal.database.ApplicationDao;
import com.dal.universityPortal.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationDao applicationDao;

    @Override
    public Boolean saveApplication(Application application) throws SQLException {
        try {
            applicationDao.insert(application);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Application readApplication(int id) throws SQLException {
        return applicationDao.fetchAllByParam(id);
    }
}
