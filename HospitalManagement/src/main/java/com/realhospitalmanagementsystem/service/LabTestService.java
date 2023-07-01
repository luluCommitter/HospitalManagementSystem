package com.realhospitalmanagementsystem.service;


import com.realhospitalmanagementsystem.entity.LabTest;
import com.realhospitalmanagementsystem.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabTestService {
    private final LabTestRepository labTestRepository;

    @Autowired
    public LabTestService(LabTestRepository labTestRepository) {
        this.labTestRepository = labTestRepository;
    }

    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }

    public LabTest getLabTestById(Long id) {
        return labTestRepository.findById(id).orElse(null);
    }

    public LabTest createLabTest(LabTest labTest) {
        return labTestRepository.save(labTest);
    }

    public LabTest updateLabTest(Long id, LabTest labTest) {
        LabTest existingLabTest = labTestRepository.findById(id).orElse(null);
        if (existingLabTest != null) {
            // Update the attributes of existingLabTest with the values from labTest
            existingLabTest.setTestName(labTest.getTestName());
            existingLabTest.setDescription(labTest.getDescription());

            return labTestRepository.save(existingLabTest);
        } else {
            return null;
        }
    }

    public boolean deleteLabTest(Long id) {
        LabTest existingLabTest = labTestRepository.findById(id).orElse(null);
        if (existingLabTest != null) {
            labTestRepository.delete(existingLabTest);
            return true;
        } else {
            return false;
        }
    }
}
