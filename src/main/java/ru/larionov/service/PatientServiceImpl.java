package ru.larionov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.larionov.dao.JdbcTemplatePatientDAO;
import ru.larionov.entity.Patient;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private JdbcTemplatePatientDAO jdbcTemplatePatientDAO;

    @Override
    public List<Patient> getListPatients() {
        return jdbcTemplatePatientDAO.getListPatients();
    }

    @Override
    public void addPatient(Patient patient) {
        jdbcTemplatePatientDAO.addPatient(patient);
    }

    @Override
    public void deletePatientById(int id) {
        jdbcTemplatePatientDAO.deletePatientById(id);
    }

    @Override
    public Patient getPatientById(int id) {
        return jdbcTemplatePatientDAO.getPatientById(id);
    }
}
