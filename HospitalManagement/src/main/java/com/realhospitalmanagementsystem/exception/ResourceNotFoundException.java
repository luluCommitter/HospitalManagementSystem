package com.realhospitalmanagementsystem.exception;





import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String entityName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : '%s'", entityName, fieldName, fieldValue));
    }

    // Other constructors or methods if needed
}




