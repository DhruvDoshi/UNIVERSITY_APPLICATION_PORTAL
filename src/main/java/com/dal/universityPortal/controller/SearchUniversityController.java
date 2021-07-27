package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.service.SearchUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.sql.SQLException;

import static com.dal.universityPortal.constant.ErrorConstant.UNIVERSITY_NOT_FOUND_ERROR;

@Controller
@RequestMapping("/student")
public class SearchUniversityController {

    @Autowired
    private SearchUniversityService searchUniversityService;

    @GetMapping("/search_university")
    public String searchUniversity(Model model) {
        Program program = new Program();
        model.addAttribute("universityDetail", program);
        return "search_university";
    }

    @PostMapping("/get_university_details")
    public String getUniversityDetails(@ModelAttribute("universityDetail") Program program,
                                       Model model, RedirectAttributes redirectAttributes) throws SQLException {
        Program universityDetails = searchUniversityService.getUniversityDetails(program);
        model.addAttribute("universityDetail", universityDetails);
        model.addAttribute("programList", searchUniversityService.getProgramDetails(universityDetails.getUserId()));
        if (universityDetails.getUniversityName().length() > 0) {
            model.addAttribute("universityDetail", universityDetails);
            return "university_details";
        } else {
            redirectAttributes.addFlashAttribute("error", UNIVERSITY_NOT_FOUND_ERROR);
            return "redirect:/student/search_university";
        }
    }
}
