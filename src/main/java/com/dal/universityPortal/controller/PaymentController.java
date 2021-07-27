package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Payment;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.service.AuthenticationService;
import com.dal.universityPortal.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping("/student")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/load_payment/{id}")
    public String loadPayment(@PathVariable (value = "id") int id,Model model) {
        Payment payment = new Payment();
        payment.setApplication_id(id);
        payment.setAmount(200);
        model.addAttribute("payment", payment);
        return "payment";
    }

    @PostMapping("/save_payment/{id}")
    public String savePayment(@PathVariable (value = "id") int id, @ModelAttribute("payment") Payment payment,HttpServletRequest request) throws SQLException {
        User currentUser = authenticationService.getCurrentUser(request.getSession());
        payment.setStudent_id(currentUser.getId());
        payment.setAmount(200);
        payment.setApplication_id(id);
        paymentService.savePayment(payment);
        return "redirect:/student/dashboard";
    }
}
