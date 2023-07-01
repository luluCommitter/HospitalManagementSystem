package com.realhospitalmanagementsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "lab_tests")
public class LabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String testName;

    @Column(nullable = false)
    private String description;


    public LabTest() {
    }

    public LabTest(String testName, String description) {
        this.testName = testName;
        this.description = description;
    }

}
