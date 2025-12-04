package com.uni4.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
public record CursoDTO(
        Long id,
        String nome,
        Integer qtdSemestres
) {}