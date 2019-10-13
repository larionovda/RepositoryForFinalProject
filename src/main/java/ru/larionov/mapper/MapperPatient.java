package ru.larionov.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.larionov.entity.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperPatient implements RowMapper<Patient> {

    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
        Patient patient = new Patient();
        patient.setId(resultSet.getInt("id"));
        patient.setName(resultSet.getString("name"));
        patient.setSurname(resultSet.getString("surname"));
        patient.setPatronymic(resultSet.getString("patronymic"));
        return patient;
    }
}
