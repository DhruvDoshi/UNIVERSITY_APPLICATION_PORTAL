package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.*;
import com.dal.universityPortal.service.AuthenticationService;
import com.dal.universityPortal.service.DashboardService;
import com.dal.universityPortal.service.ReviewApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private ReviewApplicationService reviewApplicationService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/student/dashboard")
    public String loadDashboard(Model model, HttpServletRequest request) throws SQLException {
        User currentUser = authenticationService.getCurrentUser(request.getSession());
        int studentId = currentUser.getId();
        List<Application> applicationList=dashboardService.readListApplication(studentId);
        model.addAttribute("listApplication",applicationList);
        Dashboard dashboard = dashboardService.populateAttributes(applicationList);
        List<Payment> paymentList=dashboardService.readListPayment(studentId);
        for (Payment payment : paymentList){
            dashboard.appPayment(payment.getAmount());
        }
        model.addAttribute("dashboard", dashboard);
        model.addAttribute("listPayment",paymentList);
        return "dashboard";
    }
}
