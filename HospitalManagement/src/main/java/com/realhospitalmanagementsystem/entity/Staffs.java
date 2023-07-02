package com.realhospitalmanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="staffs")
public class Staffs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Generate automatically
    @Column(name = "registration_no", nullable = false, unique = true)
    private String registrationNo;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "mobile", nullable = false)
    private long mobile;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "joining_date", nullable = false)
    private Date joinDate;

    @Column(name = "active", nullable = false)
    private boolean status;

    // Constructor without registrationNo parameter
    public Staffs(String department, String fullName, String gender, long mobile, String address, Date joinDate, boolean status) {
        this.department = department;
        this.fullName = fullName;
        this.gender = gender;
        this.mobile = mobile;
        this.address = address;
        this.joinDate = joinDate;
        this.status = status;
    }
}



