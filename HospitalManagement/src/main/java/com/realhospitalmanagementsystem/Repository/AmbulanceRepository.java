package com.realhospitalmanagementsystem.Repository;
import com.realhospitalmanagementsystem.entity.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, Long> {
    // Add custom query methods if needed
}
