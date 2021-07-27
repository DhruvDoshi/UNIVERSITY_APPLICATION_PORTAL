package com.dal.universityPortal.controller;

import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/university")
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @GetMapping("/load_program/{id}")
    public String loadUniversityProgram(@PathVariable(value = "id") int id, Model model) throws SQLException {
        Program program = new Program();
        program.setUniversityId(id);
        model.addAttribute("program", program);
        List<Program> programList=programService.readProgram(id);
        model.addAttribute("programList",programList);
        return "program";
    }

    @RequestMapping(value="/save_university_program/{id}",method= RequestMethod.POST)
    public String saveUniversityProgram(@PathVariable(value = "id") int id,@ModelAttribute("program") Program program) throws SQLException {
        program.setUniversityId(id);
        programService.saveProgram(program);
        return "redirect:/university/load_program/"+id;
    }

    @RequestMapping(value="/delete_program/{id}/{name}",method= RequestMethod.GET)
    public String deleteUniversityProgram(@PathVariable(value = "id") int id,@PathVariable(value = "name") String name) throws SQLException {
        Program program = new Program(name,id);
        programService.deleteProgram(program);
        return "redirect:/university/load_program/"+id;
    }
}
