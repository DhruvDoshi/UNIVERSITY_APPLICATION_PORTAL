package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.model.UniversityProfile;
import com.dal.universityPortal.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/loadPayment")
    public String loadPayment(Model model) throws SQLException {
        Payment payment1 = new Payment();
        model.addAttribute("payment", payment1);
        return "payment";
    }

    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute("payment") Payment payment1) throws SQLException{
        paymentService.savePayment(payment1);
        return "redirect:/";
    }
}
