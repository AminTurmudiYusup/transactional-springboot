package com.example.transactional.dto;

import lombok.Data;

@Data
public class Registration {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String jobName;
}
