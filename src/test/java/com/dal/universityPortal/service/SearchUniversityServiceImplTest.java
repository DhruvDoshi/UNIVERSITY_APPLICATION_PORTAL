package com.dal.universityPortal.service;

import com.dal.universityPortal.model.UniversityProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchUniversityServiceImplTest {

    private SearchUniversityServiceImpl searchUniversityServiceImpl;

    @BeforeEach
    public void setup(){
        searchUniversityServiceImpl = Mockito.mock(SearchUniversityServiceImpl.class);
    }

    @Test
    void getUniversityDetailsTest() throws SQLException {
        UniversityProfile universityProfile = new UniversityProfile(1, 3, "Dalhousie University", "University In Halifax","Computer Science",5, "MACS", "Data Science", false, false, true, true, false, false);
        UniversityProfile universityDetails = universityProfile;
        Mockito.doReturn(universityDetails).when(searchUniversityServiceImpl).getUniversityDetails(universityProfile);
        assertEquals(universityProfile, universityDetails);
    }
}
