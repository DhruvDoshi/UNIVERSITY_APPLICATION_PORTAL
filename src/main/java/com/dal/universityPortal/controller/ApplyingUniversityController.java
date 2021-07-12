package com.dal.universityPortal.controller;

import java.sql.SQLException;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.service.ApplyingUniversityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplyingUniversityController {

    @Autowired
    private ApplyingUniversityService applyingUniversityService;

    @PostMapping("/saveApplication")
    public String saveApplication(@ModelAttribute("application_form") Application application) throws SQLException {
        applyingUniversityService.saveApplication(application);
        return "redirect:/";
    }
    
}
