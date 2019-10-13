package ru.larionov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.larionov.entity.Patient;
import ru.larionov.service.PatientService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public String getAllPatient(Model model) {
        model.addAttribute("patients", patientService.getListPatients());
        return "listPatients";
    }

    @RequestMapping(value = {"/addPatient"}, method = RequestMethod.GET)
    public String showAddPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "createPatient";
    }

    @RequestMapping(value = {"/addPatient"}, method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("patient") Patient patient) {
        List<Patient> patients = new ArrayList<>(patientService.getListPatients());
        for (Patient patient1 : patients){
            if (patient1.getId() == patient.getId()){
                return "redirect:/addPatient";
            }
        }
        patientService.addPatient(patient);
        return "redirect:/addPatientCard" + patient.getId();
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        patientService.deletePatientById(id);
        return "redirect:/patients";
    }
}
