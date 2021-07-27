package com.dal.universityPortal.controller;

import com.dal.universityPortal.email.Sendmail;
import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.User;
import com.dal.universityPortal.service.AuthenticationService;
import com.dal.universityPortal.service.ReviewApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/university")
public class ReviewApplicationController {

    @Autowired
    private ReviewApplicationService reviewApplicationService;
    private Sendmail sendmail;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/load_list_application")
    public String loadApplicationList(Model model) throws SQLException {
        List<Application> applicationList=reviewApplicationService.readList();
        model.addAttribute("listApplication",applicationList);
        return "list_of_application";
    }

    @GetMapping("/load_application_page/{id}")
    public String loadApplication(@PathVariable(value = "id") int id,Model model) throws SQLException {
        Application application= reviewApplicationService.oneApplication(id);
        model.addAttribute("app",application);
        return "review_application";
    }

    @GetMapping(value="/lockApplication/{id}")
    public String lockApplication(@PathVariable(value = "id") int id,@ModelAttribute("application") Application application, RedirectAttributes redirectAttributes, HttpServletRequest request) throws SQLException {
        Application application1= reviewApplicationService.oneApplication(id);
        application.setApplicationId(application1.getApplicationId());
        application.setStatus("In-process");
        User currentUser = authenticationService.getCurrentUser(request.getSession());
        application.setProcessedBy(currentUser.getId());
        if(!application1.getStatus().equals("In-process")){
            reviewApplicationService.saveReviewApplication(application);
            redirectAttributes.addFlashAttribute("error", "Application is locked by you");
            return "redirect:/university/load_application_page/"+id;
        }
        else{
            redirectAttributes.addFlashAttribute("error", "Already Locked by you");
            return "redirect:/university/load_application_page/"+id;
        }
    }

    @GetMapping("/rejectApplication/{id}")
    public String rejectApplication(@PathVariable(value = "id") int id,@ModelAttribute("application") Application application, RedirectAttributes redirectAttributes) throws SQLException, MessagingException {
        Application application1= reviewApplicationService.oneApplication(id);
        application.setApplicationId(application1.getApplicationId());
        application.setStatus("Reject");
        application.setProcessedBy(application1.getProcessedBy());
        if(!application1.getStatus().equals("New")){
            reviewApplicationService.saveReviewApplication(application);
            sendmail= new Sendmail("foramgaikwad27497@gmail.com","decision made","You are not selected for the course you have applied","src/main/java/com/dal/universityPortal/email/file/reject.txt");
            sendmail.mail();
            return "redirect:/university/load_list_application";
        }
        else{
            System.out.println("New application");
            redirectAttributes.addFlashAttribute("error1", "Please lock the application to make the decision");
            return "redirect:/university/load_application_page/"+id;
        }
    }

    @RequestMapping(value="/saveReviewApplication/{id}",method= RequestMethod.POST)
    public String saveReviewApplication(@PathVariable(value = "id") int id,@ModelAttribute("application") Application application, RedirectAttributes redirectAttributes) throws SQLException, MessagingException {
        Application application1= reviewApplicationService.oneApplication(id);
        application.setApplicationId(application1.getApplicationId());
        application.setStatus("Accept");
        application.setProcessedBy(application1.getProcessedBy());
        if(!application1.getStatus().equals("New")){
            reviewApplicationService.saveReviewApplication(application);
            sendmail= new Sendmail("foramgaikwad27497@gmail.com","decision made","You are selected for the course you have applied","src/main/java/com/dal/universityPortal/email/file/accept.txt");
            sendmail.mail();
            return "redirect:/university/load_list_application";
        }
        else{
            redirectAttributes.addFlashAttribute("error1", "Please lock the application to make the decision");
            return "redirect:/university/load_application_page/"+id;
        }

    }
}
