package com.realhospitalmanagementsystem.service;

import com.realhospitalmanagementsystem.payload.AccommodationDTO;

import java.util.List;

public interface AccommodationService {
    AccommodationDTO saveAccommodation(AccommodationDTO accommodationDTO);

    AccommodationDTO getAccommodationById(Long id);

    List<AccommodationDTO> getAllAccommodations();

    void deleteAccommodation(Long id);
}
