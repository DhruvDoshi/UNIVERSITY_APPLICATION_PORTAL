package com.dal.universityPortal.service;

import com.dal.universityPortal.database.ApplicationDao;
import com.dal.universityPortal.model.Application;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    ApplicationDao applicationDao = new ApplicationDao();
    @Override
    public Boolean saveApplication(Application application) throws SQLException {
        try{
            applicationDao.insert(application);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Application readApplication(int id) throws SQLException {
        return applicationDao.fetchAllByParam(id);
    }
}
