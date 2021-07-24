package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/student")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/load_payment")
    public String loadPayment(Model model) throws SQLException {
        Payment payment1 = new Payment();
        model.addAttribute("payment", payment1);
        return "payment";
    }

    @PostMapping("/save_payment")
    public String savePayment(@ModelAttribute("payment") Payment payment1) throws SQLException {
        paymentService.savePayment(payment1);
        return "redirect:/";
    }
}