package com.realhospitalmanagementsystem.service;


import com.realhospitalmanagementsystem.entity.Hospital;

import java.util.List;

public interface HospitalService {
    Hospital addHospital(Hospital hospital);
    Hospital getHospitalById(Long id);
    List<Hospital> getAllHospitals();
    Hospital updateHospital(Long id, Hospital updatedHospital);
    void deleteHospital(Long id);
}

