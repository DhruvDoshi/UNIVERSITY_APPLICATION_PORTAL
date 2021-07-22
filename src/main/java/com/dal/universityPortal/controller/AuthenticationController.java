package com.dal.universityPortal.controller;

import com.dal.universityPortal.exceptions.UnsupportedUser;
import com.dal.universityPortal.model.Credential;
import com.dal.universityPortal.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("credential", new Credential());
        return "login";
    }

    @PostMapping("/login")
    public String saveRegistration(@ModelAttribute Credential credential, Model model, HttpServletRequest request) {
        try {
            authenticationService.login(request.getSession(), credential);
        } catch (UnsupportedUser exception) {
            model.addAttribute("credential", credential);
            model.addAttribute("errors", "The user is not supported.");
            return "login";
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return "redirect:admin/dashboard"; //TODO: implement dashboard logic
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authenticationService.logout(request.getSession());
        response.sendRedirect("/login");
    }
}
