package com.dal.universityPortal.controller;

import com.dal.universityPortal.exceptions.ValidationException;
import com.dal.universityPortal.model.University;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.model.UserType;
import com.dal.universityPortal.service.AuthenticationServiceImpl;
import com.dal.universityPortal.service.StaffServiceImpl;
import com.dal.universityPortal.service.UniversityProfileService;
import com.dal.universityPortal.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping("/university")
public class UniversityProfileController {

    @Autowired
    private UniversityProfileService universityProfileService;

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private StaffServiceImpl staffService;

    @GetMapping("/dashboard")
    public String loadUniversityProfile(Model model, HttpServletRequest request) throws SQLException {
        User currentUser = authenticationService.getCurrentUser(request.getSession());
        int id = currentUser.getId();
        University university = universityProfileService.readProfile(id);
        university.setUserId(id);
        model.addAttribute("university", university);
        return "university_profile";
    }

    @RequestMapping (value="/save_university_profile/{id}",method= RequestMethod.POST)
    public String saveUniversityProfile(@PathVariable (value = "id") int id,@ModelAttribute("university") University university,Model model) throws SQLException {
        university.setUserId(id);
        University universityCheck =universityProfileService.readProfile(id);
        if(universityCheck.getUniversityName()==null){
            universityProfileService.saveProfile(university);
        }else{
            universityProfileService.updateProfile(university);
        }

        return "redirect:/university/load_program/"+id;
    }

    @GetMapping("/add_staff")
    public String addStaffPage(Model model, HttpServletRequest request) {
        User staff = new User();
        model.addAttribute("staff", staff);
        return "add_staff";
    }

    @PostMapping("/add_staff")
    public String addStaff(@ModelAttribute User staff, Model model, HttpServletRequest request) throws ValidationException, SQLException {
        User currentUniversity = authenticationService.getCurrentUser(request.getSession());
        model.addAttribute("staff", staff);
        staff.setTypeEnum(UserType.STAFF);
        try {
            userService.addUser(staff);
            staffService.addStaffUniversityMapping(staff, currentUniversity.getId());
            return "redirect:/university/dashboard";
        } catch (ValidationException exception) {
            model.addAttribute("errors", exception.getErrors());
        } catch (SQLException exception) {
            model.addAttribute("errors", "Something went wrong, Please try again.");
        }
        return "add_staff";
    }
}