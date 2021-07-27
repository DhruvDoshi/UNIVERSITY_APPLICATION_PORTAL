package com.dal.universityPortal.service;

import com.dal.universityPortal.database.ApplicationDao;
import com.dal.universityPortal.database.UniversityDao;
import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.University;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationServiceImplTest {

    @Mock
    ApplicationDao applicationDao;

    @InjectMocks
    ApplicationServiceImpl applicationService;

    @Mock
    Application application = new Application();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void saveApplication() throws SQLException {
        applicationService.saveApplication(application);
        Mockito.verify(applicationDao).insert(application);
    }

    @Test
    void readApplication() throws SQLException {
        applicationService.readApplication(1);
        Mockito.verify(applicationDao).fetchAllByParam(1);
    }
}