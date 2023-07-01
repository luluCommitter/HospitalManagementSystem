package com.realhospitalmanagementsystem.sevice.seviceImpl;

import com.realhospitalmanagementsystem.entity.Ambulance;

import java.util.List;

public interface AmbulanceService {
    Ambulance saveAmbulance(Ambulance ambulance);
    Ambulance getAmbulanceById(Long id);
    List<Ambulance> getAllAmbulances();

    AmbulanceService deleteAmbulanceById(Long id);
    // Add more service methods as needed
}
