package ru.larionov.entity;

import javax.persistence.*;

@Entity
@Table(name = "patientCard")
public class PatientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String diagnosis;
    private String medicine;
    private String procedures;
    private String operation;
    private int patientId;

    public PatientCard() {
    }

    public PatientCard(int patientId) {
        this.patientId = patientId;
    }

    public PatientCard(int id, String diagnosis, String medicine, String procedures, String operation, int patientId) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.medicine = medicine;
        this.procedures = procedures;
        this.operation = operation;
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getProcedure() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getProcedures() {
        return procedures;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
