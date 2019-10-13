package ru.larionov.service;

import org.springframework.stereotype.Service;
import ru.larionov.entity.Patient;
import java.util.List;

@Service
public interface PatientService {
    List<Patient> getListPatients();
    void addPatient(Patient patient);
    void deletePatientById(int id);
    Patient getPatientById(int id);
}
