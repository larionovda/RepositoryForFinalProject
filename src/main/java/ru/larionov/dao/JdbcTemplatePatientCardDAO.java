package ru.larionov.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.larionov.entity.PatientCard;

@Repository
public interface JdbcTemplatePatientCardDAO {
    PatientCard getPatientCardByPatientId(int Patientid);
    void addPatientCard(PatientCard patientCard);
    void updatePatientCard(PatientCard patientCard);
}
