package com.realhospitalmanagementsystem.Controller;

import com.realhospitalmanagementsystem.payload.StaffsDto;
import com.realhospitalmanagementsystem.service.StaffsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffsController {
    @Autowired
    private StaffsService staffsService;

    @PostMapping("/register")
    public ResponseEntity<StaffsDto> registerNewStaff(@RequestBody StaffsDto staffsDto) {
        StaffsDto newStaffsDto = staffsService.registerNewUser(staffsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStaffsDto);
    }

    @GetMapping("/{registrationNo}")
    public ResponseEntity<StaffsDto> getStaffByRegistrationNo(@PathVariable String registrationNo) {
        StaffsDto staffsDto = staffsService.getStaffByRegistrationNo(registrationNo);
        return ResponseEntity.ok(staffsDto);
    }

    @GetMapping
    public ResponseEntity<List<StaffsDto>> getAllStaffs() {
        List<StaffsDto> staffsDtos = staffsService.getAllStaffs();
        return new ResponseEntity<>(staffsDtos, HttpStatus.CREATED);
    }

    @PutMapping("/{registrationNo}")
    public ResponseEntity<StaffsDto> updateStaff(@PathVariable String registrationNo, @RequestBody StaffsDto staffsDto) {
        StaffsDto updatedStaffsDto = staffsService.updateStaff(registrationNo, staffsDto);
        return new ResponseEntity<>(updatedStaffsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{registrationNo}")
    public ResponseEntity<String> deleteStaff(@PathVariable String registrationNo) {
        staffsService.deleteStaff(registrationNo);
       return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
