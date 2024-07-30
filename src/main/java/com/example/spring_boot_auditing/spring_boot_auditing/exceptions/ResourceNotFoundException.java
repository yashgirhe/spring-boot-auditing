package com.example.spring_boot_auditing.spring_boot_auditing.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
