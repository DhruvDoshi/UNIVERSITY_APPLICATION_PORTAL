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
        AdminPanel adminPanel1 = new AdminPanel(1, "Dalhousie University", "admin@dal.ca", "UNIVERSITY", "PENDING");
        AdminPanel adminPanel2 = new AdminPanel(2, "Concordia University", "admin@con.ca", "UNIVERSITY", "PENDING");
        ArrayList<AdminPanel> adminPanels = new ArrayList<>(Arrays.asList(adminPanel1, adminPanel2));
        Mockito.doReturn(adminPanels).when(adminPanelserviceImpl).getPendingStatusUniversities();
        assertEquals(2, adminPanels.size());
    }

    //TODO: Move this to constants.
    @Test
    void allowUniversityByIdTest() throws SQLException {
        AdminPanel adminPanel = new AdminPanel(1, "Dalhousie University", "admin@dal.ca", "UNIVERSITY", "PENDING");
        adminPanel.setStatus("ACTIVE");
        Mockito.doReturn(true).when(adminPanelserviceImpl).allowUniversityById(adminPanel);
        assertTrue(adminPanelserviceImpl.allowUniversityById(adminPanel));
    }

    //TODO: Move this to constants.
    @Test
    void denyUniversityByIdTest() throws SQLException {
        AdminPanel adminPanel = new AdminPanel(1, "Dalhousie University", "admin@dal.ca", "UNIVERSITY", "PENDING");
        adminPanel.setStatus("BLOCKED");
        Mockito.doReturn(true).when(adminPanelserviceImpl).denyUniversityById(adminPanel);
        assertTrue(adminPanelserviceImpl.denyUniversityById(adminPanel));
    }
}
