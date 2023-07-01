package com.realhospitalmanagementsystem.service;

import com.realhospitalmanagementsystem.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    void deletePatientById(Long id);
    Patient updatePatient(Patient patient);
}
