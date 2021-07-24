package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.Dashboard;
import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.service.AuthenticationService;
import com.dal.universityPortal.service.DashboardService;
import com.dal.universityPortal.service.ReviewApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @GetMapping("/student/loadDashboard")
    public String loadDashboard(Model model, HttpServletRequest request) throws SQLException {
        User currentUser = authenticationService.getCurrentUser(request.getSession());
        int student_id = currentUser.getId();
        Dashboard dashboard = new Dashboard();
        model.addAttribute("dashboard",dashboard);
        List<Application> applicationList=dashboardService.readListApplication(student_id);
        model.addAttribute("listApplication",applicationList);
        int successful_applications = 0;
        int in_process_applications = 0;
        int rejected_applications = 0;

        for (Application application : applicationList){
            if (application.getStatus().equals("New") || application.getStatus().equals("In-process")){
                in_process_applications++;
            }
            else if (application.getStatus().equals("Accept")){
                successful_applications++;
            }
            else {
                rejected_applications ++;
            }
        }
        model.addAttribute("successful", successful_applications);
        model.addAttribute("rejected", rejected_applications);
        model.addAttribute("in_process", in_process_applications);




        List<Payment> paymentList=dashboardService.readListPayment(student_id);
        int total_payment = 0;
        for (Payment payment : paymentList){
            total_payment = total_payment + payment.getAmount();
        }
        model.addAttribute("total_payment", total_payment);
        model.addAttribute("listPayment",paymentList);
        return "dashboard";
    }

}
