package ru.larionov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.larionov.dao.JdbcTemplatePatientDAO;
import ru.larionov.entity.Patient;


@Controller
public class PatientController {
    @Autowired
    JdbcTemplatePatientDAO jdbcTemplatePatientDAO;

    @GetMapping("/patients")
    public String getAllPatient(Model model) {
        model.addAttribute("patients", jdbcTemplatePatientDAO.getListPatients());
        return "patientList";
    }

    @GetMapping("/addPatient")
    public String createPatientPage(){
        return "createPatient";
    }

    @PostMapping("/addPatient")
    public String addPatient(Patient patient) {
        jdbcTemplatePatientDAO.addPatient(patient);
        return "redirect:/addPatientCard";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") int id){
        jdbcTemplatePatientDAO.deletePatientById(id);
        return "redirect/patients";
    }
}
