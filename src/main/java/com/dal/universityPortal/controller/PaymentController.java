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

//    @GetMapping("/savePayment")
//    public String savePayment(Model model){
//        model.addAttribute("payment", new Payment());
//        return "savePayment";
//    }

    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute("payment_info") Payment payment) throws SQLException {
        paymentService.savePayment(payment);
        return "redirect:/";
    }}
