package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.model.University;
import com.dal.universityPortal.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @GetMapping("/loadProgram/{id}")
    public String loadUniversityProgram(@PathVariable(value = "id") int id, Model model) throws SQLException {
        Program program = new Program();
        program.setUniversityId(id);
        model.addAttribute("program", program);
        List<Program> programList=programService.readProgram(id);
        model.addAttribute("programList",programList);
        return "program";
    }

    @RequestMapping(value="/saveUniversityProgram/{id}",method= RequestMethod.POST)
    public String saveUniversityProgram(@PathVariable(value = "id") int id,@ModelAttribute("program") Program program) throws SQLException {
        program.setUniversityId(id);
        programService.saveProgram(program);
        return "redirect:/loadProgram/"+id;
    }

    @RequestMapping(value="/deleteProgram/{id}/{name}",method= RequestMethod.GET)
    public String deleteUniversityProgram(@PathVariable(value = "id") int id,@PathVariable(value = "name") String name) throws SQLException {
        programService.deleteProgram(id,name);
        return "redirect:/loadProgram/"+id;
    }
}
