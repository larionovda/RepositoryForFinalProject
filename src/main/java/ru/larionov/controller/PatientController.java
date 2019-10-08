package ru.larionov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.larionov.dao.JdbcTemplatePatientDAO;
import ru.larionov.entity.Patient;

@Controller
public class PatientController {
    @Autowired
    JdbcTemplatePatientDAO jdbcTemplatePatientDAO;

    @GetMapping("/patients")
    public String getAllPatient(Model model) {
        model.addAttribute("patients", jdbcTemplatePatientDAO.getListPatients());
        return "listPatients";
    }

    @RequestMapping(value = { "/addPatient" }, method = RequestMethod.GET)
    public String showAddPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "createPatient";
    }

    @RequestMapping(value = { "/addPatient" }, method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("patient") Patient patient) {
            jdbcTemplatePatientDAO.addPatient(patient);
            return "redirect:/addPatientCard" + patient.getId();
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") int id){
        jdbcTemplatePatientDAO.deletePatientById(id);
        return "redirect/patients";
    }
}
