package ru.larionov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.larionov.dao.JdbcTemplatePatientCardDAO;
import ru.larionov.entity.PatientCard;

@Controller
public class PatientCardController {
    @Autowired
    private JdbcTemplatePatientCardDAO jdbcTemplatePatientCardDAO;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @GetMapping("/card/{id}")
    public String card(@PathVariable("id") int id, Model model) {
        model.addAttribute("card", jdbcTemplatePatientCardDAO.getPatientCardByPatientId(id));
        return "patientCard";
    }

    @GetMapping("/addPatientCard{patientId}")
    public String addPatientCard(@PathVariable("patientId") int patientId, Model model) {
        PatientCard patientCard = new PatientCard(patientId);
        model.addAttribute("patientCard", patientCard);
        return "createPatientCard";
    }

    @RequestMapping(value = { "/addPatientCard" }, method = RequestMethod.POST)
    public String addCard(Model model,
                             @ModelAttribute("patientCard") PatientCard patientCard) {
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

    @GetMapping("/updateNurse{id}")
    public String updateNurse(@PathVariable("id") int id, Model model){
        model.addAttribute("patientCard", jdbcTemplatePatientCardDAO.getPatientCardByPatientId(id));
        return "editPatientCardNurse";
    }

    @PostMapping("/updatePatientCardNurse")
    public String updatePatientCardNurse(@ModelAttribute("patientCard") PatientCard patientCard){
        jdbcTemplatePatientCardDAO.updatePatientCard(patientCard);
        return "redirect:/card/" + patientCard.getPatientId();
    }

}
