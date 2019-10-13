package ru.larionov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.larionov.dao.JdbcTemplatePatientCardDAO;
import ru.larionov.entity.PatientCard;

@Service
public class PatientCardServiceImpl implements PatientCardService {
    @Autowired
    private JdbcTemplatePatientCardDAO jdbcTemplatePatientCardDAO;

    @Override
    public PatientCard getPatientCardByPatientId(int patientid) {
        return jdbcTemplatePatientCardDAO.getPatientCardByPatientId(patientid);
    }

    @Override
    public void addPatientCard(PatientCard patientCard) {
        jdbcTemplatePatientCardDAO.addPatientCard(patientCard);
    }

    @Override
    public void updatePatientCard(PatientCard patientCard) {
        jdbcTemplatePatientCardDAO.updatePatientCard(patientCard);
    }
}
