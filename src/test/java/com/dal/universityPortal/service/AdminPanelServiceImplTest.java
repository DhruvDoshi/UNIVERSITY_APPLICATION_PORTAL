package com.dal.universityPortal.service;

import com.dal.universityPortal.model.AdminPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminPanelServiceImplTest {
    private AdminPanelServiceImpl adminPanelserviceImpl;

    @BeforeEach
    public void setup(){
        adminPanelserviceImpl = Mockito.mock(AdminPanelServiceImpl.class);
    }

    //TODO: Move this to constants.
    @Test
    void getPendingStatusUniversitiesTest() throws SQLException {
        AdminPanel adminPanel1 = new AdminPanel(1, "Dalhousie University", "admin@dal.ca", "university", "Pending");
        AdminPanel adminPanel2 = new AdminPanel(2, "Concordia University", "admin@con.ca", "university", "Pending");

        ArrayList<AdminPanel> adminPanels = new ArrayList<>(Arrays.asList(adminPanel1, adminPanel2));
        Mockito.doReturn(adminPanels).when(adminPanelserviceImpl).getPendingStatusUniversities();
        assertEquals(2, adminPanels.size());
    }

    //TODO: Move this to constants.
    @Test
    void allowUniversityByIdTest() throws SQLException {
        AdminPanel adminPanel1 = new AdminPanel(1, "Dalhousie University", "admin@dal.ca", "university", "Pending");
        adminPanel1.setStatus("Allow");
        Mockito.doReturn(true).when(adminPanelserviceImpl).allowUniversityById(1);
        assertTrue(adminPanelserviceImpl.allowUniversityById(1));
    }

    @Test
    void denyUniversityByIdTest() throws SQLException {
        AdminPanel adminPanel1 = new AdminPanel(1, "Dalhousie University", "admin@dal.ca", "university", "Pending");
        adminPanel1.setStatus("Deny");
        Mockito.doReturn(true).when(adminPanelserviceImpl).denyUniversityById(1);
        assertTrue(adminPanelserviceImpl.denyUniversityById(1));
    }
}
