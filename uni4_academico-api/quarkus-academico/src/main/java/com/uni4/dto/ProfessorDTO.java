package com.uni4.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Builder
public record ProfessorDTO(
        Long id,
        String nome,
        String email,
        UUID keycloakId
) {}