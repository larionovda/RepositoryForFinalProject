package ru.larionov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.larionov.entity.Patient;
import ru.larionov.mapper.MapperPatient;
import java.util.List;

@Repository
public class PatientImpl implements JdbcTemplatePatientDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private final static MapperPatient MAPPER_PATIENT = new MapperPatient();

    @Override
    public List<Patient> getListPatients() {
        String SQL = "select * from patient";
        return jdbcTemplate.query(SQL, MAPPER_PATIENT);
    }

    @Override
    public void addPatient(Patient patient) {
        String SQL = "insert into patient (id, name, surname, patronymic) values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL, patient.getId(), patient.getName(), patient.getSurname(), patient.getPatronymic());
    }

    @Override
    public void deletePatientById(int id) {
        String SQL = "delete from patient where id = ? ";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public Patient getPatientById(int id) {
        String SQL = "select * from patient where id = ?";
        return jdbcTemplate.queryForObject(SQL, MAPPER_PATIENT, id);
    }
}
