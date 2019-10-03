package ru.larionov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.larionov.entity.PatientCard;
import ru.larionov.mapper.MapperPatientCard;

@Repository
public class PatientCardImpl implements JdbcTemplatePatientCardDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private static final MapperPatientCard MAPPER_PATIENT_CARD = new MapperPatientCard();

    @Override
    public PatientCard getPatientCardByPatientId(int patientId) {
        String SQL = "select * from patient_card where patient_id = ?";
        return jdbcTemplate.queryForObject(SQL, MAPPER_PATIENT_CARD, patientId);
    }

    @Override
    public void addPatientCard(PatientCard patientCard) {
        String SQL = "insert into patient_card (diagnosis, medicine, procedures, operation, patient_id) values (?,?,?,?,?)";
        jdbcTemplate.update(SQL, patientCard.getDiagnosis(), patientCard.getMedicine(), patientCard.getProcedures(), patientCard.getOperation(), patientCard.getPatientId());
    }

    @Override
    public void updatePatientCard(PatientCard patientCard) {
        String SQL = "update patient_card set diagnosis = ?, medicine = ?, procedures = ?, operation = ? where id = ?";
        jdbcTemplate.update(SQL, patientCard.getDiagnosis(), patientCard.getMedicine(), patientCard.getProcedures(), patientCard.getOperation(), patientCard.getId());
    }
}
