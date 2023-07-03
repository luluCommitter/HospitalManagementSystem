package com.realhospitalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "accommodation")
@Data
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private int roomNumber;
    private String roomType;
    private int bedCount;
    private boolean occupancyStatus;
    private Date admissionDate;
    private String assignedDoctor;
    private String nurseOnDuty;
    private double roomCharges;
    private String facilities;

}
