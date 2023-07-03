package com.realhospitalmanagementsystem.controller;

import com.realhospitalmanagementsystem.entity.LabTest;
import com.realhospitalmanagementsystem.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab-tests")
public class LabTestController {
    private final LabTestService labTestService;

    @Autowired
    public LabTestController(LabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @GetMapping
    public ResponseEntity<List<LabTest>> getAllLabTests() {
        List<LabTest> labTests = labTestService.getAllLabTests();
        return new ResponseEntity<>(labTests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabTest> getLabTestById(@PathVariable("id") Long id) {
        LabTest labTest = labTestService.getLabTestById(id);
        if (labTest != null) {
            return new ResponseEntity<>(labTest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<LabTest> createLabTest(@RequestBody LabTest labTest) {
        LabTest createdLabTest = labTestService.createLabTest(labTest);
        return new ResponseEntity<>(createdLabTest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabTest> updateLabTest(@PathVariable("id") Long id, @RequestBody LabTest labTest) {
        LabTest updatedLabTest = labTestService.updateLabTest(id, labTest);
        if (updatedLabTest != null) {
            return new ResponseEntity<>(updatedLabTest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTest(@PathVariable("id") Long id) {
        boolean deleted = labTestService.deleteLabTest(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
