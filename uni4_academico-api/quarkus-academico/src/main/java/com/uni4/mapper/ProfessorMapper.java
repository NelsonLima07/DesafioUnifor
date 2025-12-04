package com.uni4.mapper;

import com.uni4.dto.ProfessorDTO;
import com.uni4.entity.Professor;

import java.util.List;
import java.util.stream.Collectors;


public class ProfessorMapper {

    public static Professor toEntity(ProfessorDTO dto) {
        if (dto == null) {
            return null;
        }
        
        return Professor.builder()
                .nome(dto.nome())
                .email(dto.email())
                .keycloakId(dto.keycloakId())
                .build();
    }
    
    public static ProfessorDTO toDTO(Professor entity) {
        if (entity == null) {
            return null;
        }

        return ProfessorDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .build();
    }

    public static List<ProfessorDTO> toResponseDTOList(List<Professor> entities) {
        if (entities == null) {
            return null;
        }
        
        return entities.stream()
                .map(ProfessorMapper::toDTO)
                .collect(Collectors.toList());
    }
}