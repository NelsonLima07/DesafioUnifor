package com.uni4.dto;

import lombok.Builder;

@Builder
public record CursoDTO(
        Long id,
        String nome,
        Integer qtdSemestres
) {}