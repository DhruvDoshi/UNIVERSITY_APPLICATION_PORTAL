package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.University;
import com.dal.universityPortal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/loadApplication/{id}")
    public String loadApplication(@PathVariable (value = "id") int id, Model model) throws SQLException {
        Application application = new Application();
        application=applicationService.readApplication(id);
        application.setApplication_id(id);
        model.addAttribute("application", application);
        return "application_form";
    }

    @RequestMapping(value="/saveApplication",method= RequestMethod.POST)
    public String saveApplication(@ModelAttribute("application") Application application) throws SQLException {
        applicationService.saveApplication(application);
        return "redirect:/";
    }
}
