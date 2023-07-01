
package com.realhospitalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Doctors_Details")
public class DoctorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name="DoctorName" , nullable = false)
    private String D_name;
    @Column(name="DoctorSpeciality" , nullable = false)
    private String D_speciality;
    @Column(name="DoctorSalary" , nullable = false)
    private String Salary;
    @Column(name="DoctorReating" , nullable = false)
    private String Reating;
}
