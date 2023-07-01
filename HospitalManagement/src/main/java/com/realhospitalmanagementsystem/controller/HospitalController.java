package com.realhospitalmanagementsystem.controller;





import com.realhospitalmanagementsystem.entity.Hospital;
import com.realhospitalmanagementsystem.exception.ResourceNotFoundException;
import com.realhospitalmanagementsystem.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    @Autowired
    private  HospitalService hospitalService;




    @PostMapping
    public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital) {
        Hospital savedHospital = hospitalService.addHospital(hospital);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHospital);
    }

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return ResponseEntity.ok(hospitals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospital(@PathVariable Long id) {
        Hospital hospital = hospitalService.getHospitalById(id);
        return ResponseEntity.ok(hospital);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable Long id, @RequestBody Hospital updatedHospital) {
        Hospital hospital = hospitalService.updateHospital(id, updatedHospital);
        return ResponseEntity.ok(hospital);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
        return ResponseEntity.noContent().build();
    }


}



