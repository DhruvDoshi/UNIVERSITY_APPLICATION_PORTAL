package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/savePayment")
    public String savePayment(Model model){
        model.addAttribute("payment", new Payment());
        return "savePayment";
    }

}
