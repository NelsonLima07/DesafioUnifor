package com.uni4.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProfessorDTO(
        Long id,
        String nome,
        String email,
        UUID keycloakId
) {}