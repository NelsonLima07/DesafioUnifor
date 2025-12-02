package com.uni4.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String role; // Pode ser "COORDENADOR", "ALUNO" ou "PROFESSOR"
}