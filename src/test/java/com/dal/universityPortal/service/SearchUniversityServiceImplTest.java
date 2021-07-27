package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Program;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchUniversityServiceImplTest {

    private SearchUniversityServiceImpl searchUniversityServiceImpl;

    @BeforeEach
    public void setup(){
        searchUniversityServiceImpl = Mockito.mock(SearchUniversityServiceImpl.class);
    }

    @Test
    void getUniversityDetailsTest() throws SQLException {
        Program program = new Program(1, "MACS", 10);
        Program universityDetail = new Program();
        universityDetail.setUserId(2);
        universityDetail.setUniversityName("Dalhousie University");
        universityDetail.setUniversityDescription("University in Halifax");
        Program universityDetails = universityDetail;
        Mockito.doReturn(universityDetails).when(searchUniversityServiceImpl).getUniversityDetails(program);
        assertEquals(universityDetails, universityDetail);
    }

    @Test
    void getProgramDetailsTest() throws SQLException {
        Program program1 = new Program(1, "MACS", 10);
        Program program2 = new Program(2, "MCS", 10);
        ArrayList<Program> programs = new ArrayList<>(Arrays.asList(program1, program2));
        Mockito.doReturn(programs).when(searchUniversityServiceImpl).getProgramDetails(program1.getUniversityId());
        assertEquals(2, programs.size());
    }
}
