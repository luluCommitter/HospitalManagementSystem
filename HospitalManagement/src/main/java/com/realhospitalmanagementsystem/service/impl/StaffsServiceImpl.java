package com.realhospitalmanagementsystem.service.impl;

import com.realhospitalmanagementsystem.Exception.ResourceNotFoundException;
import com.realhospitalmanagementsystem.Repository.StaffsRepository;
import com.realhospitalmanagementsystem.entity.Staffs;
import com.realhospitalmanagementsystem.payload.StaffsDto;
import com.realhospitalmanagementsystem.service.StaffsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StaffsServiceImpl implements StaffsService {

    private Map<Long, StaffsDto> staffsMap;

    public StaffsServiceImpl() {
        this.staffsMap = new HashMap<>();
    }
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StaffsRepository staffsRepository;


    @Override
    public StaffsDto registerNewUser(StaffsDto staffsDto) {
        Staffs staffs=  this.modelMapper.map(staffsDto, Staffs.class);
        String department = staffsDto.getDepartment();
        String registrationNo = generateRegistrationNo(department);
        staffs.setRegistrationNo(registrationNo);
        Staffs newStaffs = staffsRepository.save(staffs);
        return modelMapper.map(newStaffs, StaffsDto.class);
    }


    @Override
    public StaffsDto getStaffByRegistrationNo(String registrationNo) {
        Staffs staffs = staffsRepository.findByRegistrationNo(registrationNo).orElseThrow((()->new ResourceNotFoundException("Staff","registrationNo",registrationNo)));
        return modelMapper.map(staffs,StaffsDto.class);
    }

    @Override
    public List<StaffsDto> getAllStaffs()
    {
        List <Staffs> staffs = staffsRepository.findAll();
        List<StaffsDto> staffsDtos = staffs.stream().map(listOfStaffs-> modelMapper.map(listOfStaffs,StaffsDto.class)).collect(Collectors.toList());
        return staffsDtos;
    }

    @Override
    public StaffsDto updateStaff(String registrationNo, StaffsDto staffsDto) {
        Staffs staffs = staffsRepository.findByRegistrationNo(registrationNo).orElseThrow((()->new ResourceNotFoundException("Staffs","registrationNo",registrationNo)));
        Staffs updatedStaffs= modelMapper.map(staffsDto,Staffs.class);
        updatedStaffs.setRegistrationNo(registrationNo);
        Staffs updatedStaff= staffsRepository.save(updatedStaffs);
        return modelMapper.map(updatedStaff,StaffsDto.class);

    }

    @Override
    public void deleteStaff(String registrationNo) {
        Staffs staff = staffsRepository.findByRegistrationNo(registrationNo)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "registrationNo", registrationNo));
        staffsRepository.delete(staff);
    }

    //Generate Registration based on Department and Random Long Integer
    @Override
    public String generateRegistrationNo(String department) {
        String departmentCode = department.substring(0, Math.min(department.length(), 5)).toUpperCase();
        Random random = new Random();
        int randomInt = random.nextInt(90000) + 10000;
        return departmentCode + randomInt;
    }
}
