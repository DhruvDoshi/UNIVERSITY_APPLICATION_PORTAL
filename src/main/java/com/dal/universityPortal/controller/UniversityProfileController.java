package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.UniversityProfile;
import com.dal.universityPortal.service.UniversityProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping (value="/saveUniversityProfile",method= RequestMethod.POST)
    public String saveUniversityProfile(@ModelAttribute("university_profile") UniversityProfile universityProfile) throws SQLException {
        universityProfileService.saveProfile(universityProfile);
        return "redirect:/";
    }

    @RequestMapping (value="/deleteUniversityProfile",method= RequestMethod.POST)
    public String deleteUniversityProfile(@ModelAttribute("university_profile") UniversityProfile universityProfile) throws SQLException {
        universityProfileService.deleteProfile(universityProfile);
        return "redirect:/";
    }

    @RequestMapping (value="/cancelUniversityProfile",method= RequestMethod.POST)
    public String cancelUniversityProfile(@ModelAttribute("university_profile") UniversityProfile universityProfile){
        return "redirect:/";
    }


}