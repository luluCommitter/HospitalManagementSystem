package com.realhospitalmanagementsystem.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AmbulanceNotFoundException extends RuntimeException {
    public AmbulanceNotFoundException(String message) {
        super(message);
    }
}
