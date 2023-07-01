package com.realhospitalmanagementsystem.repository;

import com.realhospitalmanagementsystem.entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, Long> {
}

