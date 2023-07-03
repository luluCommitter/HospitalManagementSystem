package com.realhospitalmanagementsystem.sevice.seviceImpl;

import com.realhospitalmanagementsystem.Repository.AccommodationRepository;
import com.realhospitalmanagementsystem.entity.Accommodation;
import com.realhospitalmanagementsystem.payload.AccommodationDTO;
import com.realhospitalmanagementsystem.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public AccommodationDTO saveAccommodation(AccommodationDTO accommodationDTO) {
        Accommodation accommodation = convertToEntity(accommodationDTO);
        return convertToDTO(accommodationRepository.save(accommodation));
    }

    @Override
    public AccommodationDTO getAccommodationById(Long id) {
        return accommodationRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<AccommodationDTO> getAllAccommodations() {
        return accommodationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccommodation(Long id) {
        accommodationRepository.deleteById(id);
    }

    private Accommodation convertToEntity(AccommodationDTO accommodationDTO) {
        Accommodation accommodation = new Accommodation();
        accommodation.setId(accommodationDTO.getId());
        accommodation.setPatientId(accommodationDTO.getPatientId());
        accommodation.setRoomNumber(accommodationDTO.getRoomNumber());
        accommodation.setRoomType(accommodationDTO.getRoomType());
        accommodation.setBedCount(accommodationDTO.getBedCount());
        accommodation.setOccupancyStatus(accommodationDTO.isOccupancyStatus());
        accommodation.setAdmissionDate(accommodationDTO.getAdmissionDate());
        accommodation.setAssignedDoctor(accommodationDTO.getAssignedDoctor());
        accommodation.setNurseOnDuty(accommodationDTO.getNurseOnDuty());
        accommodation.setRoomCharges(accommodationDTO.getRoomCharges());
        accommodation.setFacilities(accommodationDTO.getFacilities());
        return accommodation;
    }

    private AccommodationDTO convertToDTO(Accommodation accommodation) {
        AccommodationDTO accommodationDTO = new AccommodationDTO();
        accommodationDTO.setId(accommodation.getId());
        accommodationDTO.setPatientId(accommodation.getPatientId());
        accommodationDTO.setRoomNumber(accommodation.getRoomNumber());
        accommodationDTO.setRoomType(accommodation.getRoomType());
        accommodationDTO.setBedCount(accommodation.getBedCount());
        accommodationDTO.setOccupancyStatus(accommodation.isOccupancyStatus());
        accommodationDTO.setAdmissionDate(accommodation.getAdmissionDate());
        accommodationDTO.setAssignedDoctor(accommodation.getAssignedDoctor());
        accommodationDTO.setNurseOnDuty(accommodation.getNurseOnDuty());
        accommodationDTO.setRoomCharges(accommodation.getRoomCharges());
        accommodationDTO.setFacilities(accommodation.getFacilities());
        return accommodationDTO;
    }
}
