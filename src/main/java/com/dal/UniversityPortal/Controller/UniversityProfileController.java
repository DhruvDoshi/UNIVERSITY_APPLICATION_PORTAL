package com.dal.UniversityPortal.Controller;

import com.dal.UniversityPortal.model.university_profile;
import com.dal.UniversityPortal.service.UniversityProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UniversityProfileController {

    @Autowired
    private UniversityProfileService universityProfileService;

    @GetMapping("/addUniversityProfile")
    public String addUniversityProfile(Model model) {
        university_profile up = new university_profile();
        model.addAttribute("university_profile", up);
        return "university_profile";
    }

    @PostMapping("/saveUniversityProfile")
    public String saveUniversityProfile(@ModelAttribute("university_profile") university_profile up) {
        universityProfileService.saveUniversityProfile(up);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        university_profile up = universityProfileService.getUniversityProfileById(id);
        up.setAuthenticationId(1);
        model.addAttribute("university_profile", up);
        return "update_university_profile";
    }

}
