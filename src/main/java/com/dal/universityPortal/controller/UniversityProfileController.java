package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.UniversityProfile;
import com.dal.universityPortal.service.UniversityProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class UniversityProfileController {

    @Autowired
    private UniversityProfileService universityProfileService;

    @GetMapping("/loadUniversityProfile")
    public String loadUniversityProfile(Model model) throws SQLException {
        UniversityProfile universityProfile= universityProfileService.readProfile();
        model.addAttribute("university_profile", universityProfile);
        return "university_profile";
    }

    @PostMapping("/saveUniversityProfile")
    public String saveUniversityProfile(@ModelAttribute("university_profile") UniversityProfile universityProfile) throws SQLException {
        universityProfileService.saveProfile(universityProfile);
        return "redirect:/";
    }
}