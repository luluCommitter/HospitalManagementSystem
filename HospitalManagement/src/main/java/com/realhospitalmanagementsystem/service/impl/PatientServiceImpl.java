package com.realhospitalmanagementsystem.service.impl;

import com.realhospitalmanagementsystem.entity.Patient;
import com.realhospitalmanagementsystem.repository.PatientRepository;
import com.realhospitalmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Optional<Patient> optionalPatient = patientRepository.findById(patient.getId());
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            // Update the fields of the existing patient with the new data
            existingPatient.setPatientName(patient.getPatientName());
            existingPatient.setAge(patient.getAge());
            existingPatient.setAddress(patient.getAddress());
            existingPatient.setGender(patient.getGender());
            existingPatient.setMobileNo(patient.getMobileNo());
            existingPatient.setDepartment(patient.getDepartment());
            return patientRepository.save(existingPatient);
        } else {
            throw new IllegalArgumentException("Patient not found with ID: " + patient.getId());
        }
    }
}
