package com.example.userjwt.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String role;
}
