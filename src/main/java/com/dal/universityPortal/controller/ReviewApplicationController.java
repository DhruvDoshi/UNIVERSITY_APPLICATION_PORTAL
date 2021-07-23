package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.service.ReviewApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ReviewApplicationController {

    @Autowired
    private ReviewApplicationService reviewApplicationService;

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
    public String lockApplication(@PathVariable(value = "id") int id,@ModelAttribute("application") Application application, RedirectAttributes redirectAttributes) throws SQLException {
        Application application1= reviewApplicationService.oneApplication(id);
        application.setApplication_id(application1.getApplication_id());
        application.setStatus("In-process");
        application.setProcessed_by(1);  // get current user
        if(!application1.getStatus().equals("In-process")){
            reviewApplicationService.saveReviewApplication(application);
            return "redirect:/load_application_page/"+id;
        }
        else{
            redirectAttributes.addFlashAttribute("error", "Already Locked by you");
            return "redirect:/load_application_page/"+id;
        }
    }

    @GetMapping("/rejectApplication/{id}")
    public String rejectApplication(@PathVariable(value = "id") int id,@ModelAttribute("application") Application application) throws SQLException {
        Application application1= reviewApplicationService.oneApplication(id);
        application.setApplication_id(application1.getApplication_id());
        application.setStatus("Reject");
        application.setProcessed_by(application1.getProcessed_by());
        if(!application1.getStatus().equals("New")){
            reviewApplicationService.saveReviewApplication(application);
        }
        else{
            System.out.println("New application");
        }
        return "redirect:/load_list_application";
    }

    @RequestMapping(value="/saveReviewApplication/{id}",method= RequestMethod.POST)
    public String saveReviewApplication(@PathVariable(value = "id") int id,@ModelAttribute("application") Application application) throws SQLException {
        Application application1= reviewApplicationService.oneApplication(id);
        application.setApplication_id(application1.getApplication_id());
        application.setStatus("Accept");
        application.setProcessed_by(application1.getProcessed_by());
        if(!application1.getStatus().equals("New")){
            reviewApplicationService.saveReviewApplication(application);
        }
        else{
            System.out.println("New application");
        }
        return "redirect:/load_list_application";
    }
}
