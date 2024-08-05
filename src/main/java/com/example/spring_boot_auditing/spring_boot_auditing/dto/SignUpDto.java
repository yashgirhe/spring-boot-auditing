package com.example.spring_boot_auditing.spring_boot_auditing.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String email;
    private String password;
    private String name;
}