package com.realhospitalmanagementsystem.service;

import com.realhospitalmanagementsystem.payload.StaffsDto;

import java.util.List;

public interface StaffsService {

        public StaffsDto registerNewUser(StaffsDto staffsDto);

        public StaffsDto getStaffByRegistrationNo(String registrationNo);

        public List<StaffsDto> getAllStaffs();

        StaffsDto updateStaff(String registrationNo, StaffsDto staffsDto);

        void deleteStaff(String registrationNo);

        String generateRegistrationNo(String department);
    }

