package com.realhospitalmanagementsystem.Exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(Long id) {
        super("Department not found with id: " + id);
    }
}
