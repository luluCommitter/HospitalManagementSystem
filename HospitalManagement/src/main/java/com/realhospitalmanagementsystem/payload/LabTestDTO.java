package com.realhospitalmanagementsystem.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabTestDTO {
    private Long id;
    private String testName;
    private String description;

    public LabTestDTO() {
    }

    public LabTestDTO(Long id, String testName, String description) {
        this.id = id;
        this.testName = testName;
        this.description = description;
    }

}

