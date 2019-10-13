package ru.larionov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.larionov.entity.PatientCard;
import ru.larionov.service.PatientCardService;
import ru.larionov.service.PatientService;

@Controller
public class PatientCardController {
    @Autowired
    private PatientCardService patientCardService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/card{id}")
    public String card(@PathVariable("id") int id, Model model) {
        model.addAttribute("card", patientCardService.getPatientCardByPatientId(id));
        model.addAttribute("patient", patientService.getPatientById(id));
        return "cardPatient";
    }

    @GetMapping("/addPatientCard{patientId}")
    public String addPatientCard(@PathVariable("patientId") int patientId, Model model) {
        PatientCard patientCard = new PatientCard(patientId);
        model.addAttribute("patientCard", patientCard);
        return "createPatientCard";
    }

    @RequestMapping(value = {"/addPatientCard"}, method = RequestMethod.POST)
    public String addCard(Model model,
                          @ModelAttribute("patientCard") PatientCard patientCard) {
        patientCardService.addPatientCard(patientCard);
        return "redirect:/patients";
    }

    @GetMapping("/update{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("patientCard", patientCardService.getPatientCardByPatientId(id));
        model.addAttribute("patient", patientService.getPatientById(id));
        return "editPatientCard";
    }

    @PostMapping("/updatePatientCard")
    public String updatePatientCard(@ModelAttribute("patientCard") PatientCard patientCard) {
        patientCardService.updatePatientCard(patientCard);
        return "redirect:/card" + patientCard.getPatientId();
    }

    @GetMapping("/updateNurse{id}")
    public String updateNurse(@PathVariable("id") int id, Model model) {
        model.addAttribute("patientCard", patientCardService.getPatientCardByPatientId(id));
        model.addAttribute("patient", patientService.getPatientById(id));
        return "editPatientCardNurse";
    }

    @PostMapping("/updatePatientCardNurse")
    public String updatePatientCardNurse(@ModelAttribute("patientCard") PatientCard patientCard) {
        patientCardService.updatePatientCard(patientCard);
        return "redirect:/card" + patientCard.getPatientId();
    }

}
