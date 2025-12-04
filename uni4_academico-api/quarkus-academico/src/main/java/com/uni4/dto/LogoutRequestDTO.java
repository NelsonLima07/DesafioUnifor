package com.uni4.dto;

import lombok.Data;

@Data
public class LogoutRequestDTO {
    private String username;
    private String password;
}