package com.example.spring_boot_auditing.spring_boot_auditing.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
}