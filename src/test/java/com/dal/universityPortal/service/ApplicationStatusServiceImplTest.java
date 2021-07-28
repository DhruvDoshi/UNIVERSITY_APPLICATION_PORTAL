package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.model.University;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationStatusServiceImplTest {

    private ApplicationStatusServiceImpl applicationStatusServiceImpl;

    @BeforeEach
    public void setup(){
        applicationStatusServiceImpl = Mockito.mock(ApplicationStatusServiceImpl.class);
    }

    @Test
    void getApplicationDetailsTest() throws SQLException {
        Application application = new Application();
        application.setAppId(1);
        application.setStatus("Accepted");
        application.setProgramId(61);
        Application applicationDetails = application;
        Mockito.doReturn(applicationDetails).when(applicationStatusServiceImpl).getApplicationDetails(application.getAppId());
        assertEquals(applicationDetails, application);
    }

    @Test
    void getProgramDetailsTest() throws SQLException {
        Program program = new Program(1, "MACS", 10);
        Program programDetails = program;
        Mockito.doReturn(programDetails).when(applicationStatusServiceImpl).getProgramDetails(program.getId());
        assertEquals(programDetails, program);
    }

    @Test
    void getUniversityDetailsTest() throws SQLException {
        University university = new University(1, "Dalhousie University", "University in Halifax");
        University universityDetails = university;
        Mockito.doReturn(universityDetails).when(applicationStatusServiceImpl).getUniversityDetails(university.getUserId());
        assertEquals(universityDetails, university);
    }
}
