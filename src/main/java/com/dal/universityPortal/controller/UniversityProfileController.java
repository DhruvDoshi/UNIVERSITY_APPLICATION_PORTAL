package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.University;
import com.dal.universityPortal.service.UniversityProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/university")
public class UniversityProfileController {

    @Autowired
    private UniversityProfileService universityProfileService;

    @GetMapping("/loadUniversityProfile/{id}")
    public String loadUniversityProfile(@PathVariable (value = "id") int id,Model model) throws SQLException {
        University university = new University();
        university.setUserId(id);
        model.addAttribute("university", university);
        return "university_profile";
    }

    @RequestMapping (value="/saveUniversityProfile/{id}",method= RequestMethod.POST)
    public String saveUniversityProfile(@PathVariable (value = "id") int id,@ModelAttribute("university") University university,Model model) throws SQLException {
        university.setUserId(id);
        universityProfileService.saveProfile(university);
        return "redirect:/loadProgram/"+id;
    }
}