package com.dal.universityPortal.service;

import com.dal.universityPortal.model.UniversityProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniversityProfileServiceImplTest {
    private UniversityProfileServiceImpl universityProfileService;

    @BeforeEach
    public void setup(){
        universityProfileService = Mockito.mock(UniversityProfileServiceImpl.class);
    }

    @Test
    void saveProfileTest() throws SQLException {
        UniversityProfile universityProfile = new UniversityProfile(1, 3, "Dalhousie University",
                "University In Halifax","Computer Science",5, "MACS",
                "Data Science", false, false, true,
                true, false, false);
        Mockito.doReturn(true).when(universityProfileService).saveProfile(universityProfile);
        assertTrue(universityProfileService.saveProfile(universityProfile));
    }

    @Test
    void readProfileTest() throws SQLException {
        UniversityProfile universityProfile = new UniversityProfile(1, 3, "Dalhousie University",
                "University In Halifax","Computer Science",5, "MACS",
                "Data Science", false, false, true,
                true, false, false);
        UniversityProfile universityDetails = universityProfile;
        Mockito.doReturn(universityDetails).when(universityProfileService).readProfile();
        assertEquals(universityProfile, universityDetails);
    }

    @Test
    void deleteProfileTest() throws SQLException {
        UniversityProfile universityProfile = new UniversityProfile(1, 3, "Dalhousie University",
                "University In Halifax","Computer Science",5, "MACS",
                "Data Science", false, false, true,
                true, false, false);
        Mockito.doReturn(true).when(universityProfileService).deleteProfile(universityProfile);
        assertTrue(universityProfileService.deleteProfile(universityProfile));
    }

}
