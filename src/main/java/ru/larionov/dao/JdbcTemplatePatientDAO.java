package ru.larionov.dao;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.larionov.entity.Patient;

import java.util.List;

@Repository
public interface JdbcTemplatePatientDAO {
    List<Patient> getListPatients();
    void addPatient(Patient patient);
    void deletePatientById(int id);
}
