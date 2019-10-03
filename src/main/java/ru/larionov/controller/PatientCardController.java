package ru.larionov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.larionov.dao.JdbcTemplatePatientCardDAO;
import ru.larionov.entity.PatientCard;

import java.util.Map;

@Controller
public class PatientCardController {
    @Autowired
    private JdbcTemplatePatientCardDAO jdbcTemplatePatientCardDAO;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/card/{id}")
    public String card(@PathVariable("id") int id, Model model) {
        model.addAttribute("card", jdbcTemplatePatientCardDAO.getPatientCardByPatientId(id));
        return "patientCard";
    }

    @GetMapping("/addPatientCard")
    public String createPatientCardPage(){
        return "createPatientCard";
    }

    @PostMapping("/addPatientCard")
    public String addPatientCard(PatientCard patientCard){
        jdbcTemplatePatientCardDAO.addPatientCard(patientCard);
        return "redirect:/patients";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("patientCard", jdbcTemplatePatientCardDAO.getPatientCardByPatientId(id));
        return "editPatientCard";
    }

    @PostMapping("/updatePatientCard")
    public String updatePatientCard(@ModelAttribute("patientCard") PatientCard patientCard){
        jdbcTemplatePatientCardDAO.updatePatientCard(patientCard);
        return "redirect:/card/" + patientCard.getPatientId();
    }

}
