package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.service.ApplicationService;
import com.dal.universityPortal.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping("/student")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/load_application/{id}")
    public String loadApplication(@PathVariable (value = "id") int id, Model model) throws SQLException {
        Application application = new Application();
        model.addAttribute("application", application);
        return "application_form";
    }

    @RequestMapping(value="/save_application/{id}",method= RequestMethod.POST)
    public String saveApplication(@PathVariable (value = "id") int id, @ModelAttribute("application") Application application, HttpServletRequest request) throws SQLException {
        User currentUser = authenticationService.getCurrentUser(request.getSession());
        application.setProgram_id(id);
        application.setStudent_id(currentUser.getId());
        applicationService.saveApplication(application);
        return "redirect:/student/load_payment";
    }
}
