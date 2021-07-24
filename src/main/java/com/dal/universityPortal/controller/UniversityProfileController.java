package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.model.University;
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

    @GetMapping("/loadUniversityProfile/{id}")
    public String loadUniversityProfile(@PathVariable (value = "id") int id,Model model) throws SQLException {
        University university = universityProfileService.readProfile(id);
        university.setUserId(id);
        model.addAttribute("university", university);
        return "university_profile";
    }

    @RequestMapping (value="/saveUniversityProfile/{id}",method= RequestMethod.POST)
    public String saveUniversityProfile(@PathVariable (value = "id") int id,@ModelAttribute("university") University university,Model model) throws SQLException {
        university.setUserId(id);
        University universityCheck =universityProfileService.readProfile(id);
        if(universityCheck.getUniversityName()==null){
            universityProfileService.saveProfile(university);
        }else{
            universityProfileService.updateProfile(university);
        }

        return "redirect:/loadProgram/"+id;
    }
}