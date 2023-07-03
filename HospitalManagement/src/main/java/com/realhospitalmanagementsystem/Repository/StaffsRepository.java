package com.realhospitalmanagementsystem.Repository;

import com.realhospitalmanagementsystem.entity.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import java.util.Optional;

public interface StaffsRepository extends JpaRepository<Staffs, Long> {
    Optional<Staffs> findByRegistrationNo(String registrationNo);
}
