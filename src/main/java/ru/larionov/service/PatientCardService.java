package ru.larionov.service;

import org.springframework.stereotype.Service;
import ru.larionov.entity.PatientCard;

@Service
public interface PatientCardService {
    PatientCard getPatientCardByPatientId(int patientid);
    void addPatientCard(PatientCard patientCard);
    void updatePatientCard(PatientCard patientCard);
}
