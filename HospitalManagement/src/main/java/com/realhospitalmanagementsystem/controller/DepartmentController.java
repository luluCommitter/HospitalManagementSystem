package com.realhospitalmanagementsystem.controller;

import com.realhospitalmanagementsystem.Exception.DoctorNotFoundException;
import com.realhospitalmanagementsystem.repository.DepartmentRepository;
import com.realhospitalmanagementsystem.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));

        department.setDoctorName(updatedDepartment.getDoctorName());
        department.setDepartment(updatedDepartment.getDepartment());

        Department savedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(savedDepartment);
    }


    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        departmentRepository.delete(department);
    }
}
