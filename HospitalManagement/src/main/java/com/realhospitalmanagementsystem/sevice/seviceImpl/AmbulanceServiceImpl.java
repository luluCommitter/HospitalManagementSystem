package com.realhospitalmanagementsystem.sevice.seviceImpl;

import com.realhospitalmanagementsystem.Repository.AmbulanceRepository;
import com.realhospitalmanagementsystem.entity.Ambulance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {
    private final AmbulanceRepository ambulanceRepository;

    @Autowired
    public AmbulanceServiceImpl(AmbulanceRepository ambulanceRepository) {
        this.ambulanceRepository = ambulanceRepository;
    }

    @Override
    public Ambulance saveAmbulance(Ambulance ambulance) {
        return null;
    }

    @Override
    public Ambulance getAmbulanceById(Long id) {
        return ambulanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ambulance> getAllAmbulances() {
        return ambulanceRepository.findAll();
    }

    @Override
    public AmbulanceService deleteAmbulanceById(Long id) {
        return null;
    }

    // Add more service methods as needed
}
