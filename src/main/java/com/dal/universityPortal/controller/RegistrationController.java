package com.dal.universityPortal.controller;

import com.dal.universityPortal.exceptions.ValidationException;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class RegistrationController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String saveRegistration(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        try {
            userService.addUser(user);
            return "redirect:/login";
        } catch (ValidationException exception) {
            model.addAttribute("errors", exception.getErrors());
        } catch (SQLException exception) {
            model.addAttribute("errors", "Something went wrong, Please try again.");
        }
        return "registration";
    }
}
