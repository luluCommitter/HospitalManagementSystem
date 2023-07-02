package com.realhospitalmanagementsystem.payload;

import lombok.Data;

import java.util.Date;

@Data
public class StaffsDto {

    private  long id;

    private String  registrationNo;

    private String department;

    private String fullName;

    private String gender;

    private long mobile;

    private String address;

    private Date joinDate;

    private boolean status;
}
