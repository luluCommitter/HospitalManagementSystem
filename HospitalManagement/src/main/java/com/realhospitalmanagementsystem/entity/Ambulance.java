package com.realhospitalmanagementsystem.entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Ambulance_Details")
public class Ambulance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name="RegistrationNumber" , nullable = false)
    private String registrationNumber;
    @Column(name="DriverName" , nullable = false)
    private String driverName;
    @Column(name="HospitalName" , nullable = false)
    private String hospitalName;
    @Column(name="Location" , nullable = false)
    private String location;
    @Column(name="AmbulanceNo" , nullable = false)
    private Integer AmbulanceNo;

    // Add more fields and methods as per your requirements
}

