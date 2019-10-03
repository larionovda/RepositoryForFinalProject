package ru.larionov.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.larionov.entity.PatientCard;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperPatientCard implements RowMapper<PatientCard> {
    @Override
    public PatientCard mapRow(ResultSet resultSet, int i) throws SQLException {
        PatientCard patientCard = new PatientCard();
        patientCard.setId(resultSet.getInt("id"));
        patientCard.setDiagnosis(resultSet.getString("diagnosis"));
        patientCard.setMedicine(resultSet.getString("medicine"));
        patientCard.setProcedures(resultSet.getString("procedures"));
        patientCard.setOperation(resultSet.getString("operation"));
        patientCard.setPatientId(resultSet.getInt("patient_id"));
        return patientCard;
    }
}
