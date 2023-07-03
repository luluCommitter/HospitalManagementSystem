package com.realhospitalmanagementsystem.serviceImpl;


import com.realhospitalmanagementsystem.entity.Hospital;
import com.realhospitalmanagementsystem.exception.ResourceNotFoundException;
import com.realhospitalmanagementsystem.repository.HospitalRepository;
import com.realhospitalmanagementsystem.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hospital", "id", id));
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital updateHospital(Long id, Hospital updatedHospital) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hospital", "id", id));

        hospital.setHospitalName(updatedHospital.getHospitalName());
        hospital.setAddress(updatedHospital.getAddress());
        hospital.setMobileNo(updatedHospital.getMobileNo());
        hospital.setEstablishmentDate(updatedHospital.getEstablishmentDate());

        return hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospital(Long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hospital", "id", id));

        hospitalRepository.delete(hospital);
    }
}
