package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.AdminPanel;
import com.dal.universityPortal.service.AdminPanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;

@Controller
public class AdminPanelController {

    @Autowired
    private AdminPanelService adminPanelService;

    @GetMapping("/adminPanel")
    public String getUniversities(Model model) throws SQLException {
        model.addAttribute("listUniversities", adminPanelService.getPendingStatusUniversities());
        return "admin_panel";
    }

    @GetMapping("/allowUniversity/{id}")
    public String allowUniversity(@PathVariable(value = "id") int id, Model model) throws SQLException {
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.setUserId(id);
        this.adminPanelService.allowUniversityById(adminPanel);
        model.addAttribute("listUniversities", adminPanelService.getPendingStatusUniversities());
        return "admin_panel";
    }

    @GetMapping("/denyUniversity/{id}")
    public String denyUniversity(@PathVariable (value = "id") int id, Model model) throws SQLException {
        AdminPanel adminPanel = new AdminPanel();
        adminPanel.setUserId(id);
        this.adminPanelService.denyUniversityById(adminPanel);
        model.addAttribute("listUniversities", adminPanelService.getPendingStatusUniversities());
        return "admin_panel";
    }
}
