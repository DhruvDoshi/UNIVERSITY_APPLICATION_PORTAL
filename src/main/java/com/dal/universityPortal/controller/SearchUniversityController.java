package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.UniversityProfile;
import com.dal.universityPortal.service.SearchUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;

@Controller
public class SearchUniversityController {

    @Autowired
    private SearchUniversityService searchUniversityService;

    @GetMapping("/searchUniversity")
    public String searchUniversity(Model model) {
        UniversityProfile universityProfile = new UniversityProfile(
                0, 0, "", "",
                "", 0, "", "",
                false, false, false, false,
                false, false);
        model.addAttribute("universityDetail", universityProfile);
        return "search_university";
    }

    @PostMapping("/getUniversityDetails")
    public String getUniversityDetails(@ModelAttribute("universityDetail") UniversityProfile universityProfile,
                                       Model model, RedirectAttributes redirectAttributes) throws SQLException {
        UniversityProfile universityDetails = searchUniversityService.getUniversityDetails(universityProfile);
        if (universityDetails.getUniversityName() != "") {
            model.addAttribute("universityDetail", universityDetails);
            return "university_details";
        } else {
            redirectAttributes.addFlashAttribute("error", "University Not Found!!!");
            return "redirect:/searchUniversity";
        }
    }
}
