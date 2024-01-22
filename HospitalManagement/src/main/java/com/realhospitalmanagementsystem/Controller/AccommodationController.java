package com.realhospitalmanagementsystem.Controller;

import com.realhospitalmanagementsystem.payload.AccommodationDTO;
import com.realhospitalmanagementsystem.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {
    private final AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @PostMapping
    public AccommodationDTO saveAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        return accommodationService.saveAccommodation(accommodationDTO);
    }

    @GetMapping("/{id}")
    public AccommodationDTO getAccommodationById(@PathVariable Long id) {
        return accommodationService.getAccommodationById(id);
    }

    @GetMapping
    public List<AccommodationDTO> getAllAccommodations() {
        return accommodationService.getAllAccommodations();
    }

    @PutMapping("/{id}")
    public AccommodationDTO updateAccommodation(@PathVariable Long id, @RequestBody AccommodationDTO updatedAccommodationDTO) {
       return null ;
    }

    @DeleteMapping("/{id}")
    public void deleteAccommodation(@PathVariable Long id) {
        accommodationService.deleteAccommodation(id);
    }
}

jjj