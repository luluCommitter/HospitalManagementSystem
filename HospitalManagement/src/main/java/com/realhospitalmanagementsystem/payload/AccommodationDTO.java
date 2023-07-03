package com.realhospitalmanagementsystem.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class AccommodationDTO {
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

