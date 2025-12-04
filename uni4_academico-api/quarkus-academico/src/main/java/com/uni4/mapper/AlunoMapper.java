package com.uni4.mapper;

import com.uni4.dto.AlunoDTO;
import com.uni4.entity.Aluno;

import java.util.List;
import java.util.stream.Collectors;


public class AlunoMapper {

    public static Aluno toEntity(AlunoDTO dto) {
        if (dto == null) {
            return null;
        }
        
        return Aluno.builder()
                .nome(dto.nome())
                .email(dto.email())
                .keycloakId(dto.keycloakId())
                .build();
    }
    
    public static AlunoDTO toDTO(Aluno entity) {
        if (entity == null) {
            return null;
        }

        return AlunoDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .build();
    }

    public static List<AlunoDTO> toResponseDTOList(List<Aluno> entities) {
        if (entities == null) {
            return null;
        }
        
        return entities.stream()
                .map(AlunoMapper::toDTO)
                .collect(Collectors.toList());
    }
}