package com.realhospitalmanagementsystem.Controller;

import com.realhospitalmanagementsystem.entity.Ambulance;
import com.realhospitalmanagementsystem.sevice.seviceImpl.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambulances")
public class AmbulanceController {
    private final AmbulanceService ambulanceService;

    @Autowired
    public AmbulanceController(AmbulanceService ambulanceService) {
        this.ambulanceService = ambulanceService;
    }

    @PostMapping
    public ResponseEntity<Ambulance> createAmbulance(@RequestBody Ambulance ambulance) {
        Ambulance savedAmbulance = ambulanceService.saveAmbulance(ambulance);
        return new ResponseEntity<>(savedAmbulance, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ambulance> getAmbulanceById(@PathVariable Long id) {
        Ambulance ambulance = ambulanceService.getAmbulanceById(id);
        if (ambulance != null) {
            return new ResponseEntity<>(ambulance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Ambulance>> getAllAmbulances() {
        List<Ambulance> ambulances = ambulanceService.getAllAmbulances();
        return new ResponseEntity<>(ambulances, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ambulance> updateAmbulance(@PathVariable Long id, @RequestBody Ambulance updatedAmbulance) {
        Ambulance ambulance = ambulanceService.getAmbulanceById(id);
        if (ambulance != null) {
            updatedAmbulance.setId(id);
            Ambulance savedAmbulance = ambulanceService.saveAmbulance(updatedAmbulance);
            return new ResponseEntity<>(savedAmbulance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmbulance(@PathVariable Long id) {
        Ambulance ambulance = ambulanceService.getAmbulanceById(id);
        if (ambulance != null) {
            ambulanceService.deleteAmbulanceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add more controller methods as needed
}
