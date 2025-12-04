package com.uni4.mapper;

import com.uni4.dto.CursoDTO;
import com.uni4.entity.Curso;

import java.util.List;
import java.util.stream.Collectors;


public class CursoMapper {

    public static Curso toEntity(CursoDTO dto) {
        if (dto == null) {
            return null;
        }
        
        return Curso.builder()
                .nome(dto.nome())
                .qtdSemestres(dto.qtdSemestres())
                .build();
    }
    
    /**
     * Converte a Entidade (do banco de dados) para o DTO de Resposta (output para o cliente).
     * Usado em operações GET, POST e PUT.
     */
    public static CursoDTO toDTO(Curso entity) {
        if (entity == null) {
            return null;
        }

        return CursoDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .qtdSemestres(entity.getQtdSemestres())
                .build();
    }

    /**
     * Converte uma Lista de Entidades para uma Lista de DTOs de Resposta.
     * Usado na operação GET (listAll).
     */
    public static List<CursoDTO> toResponseDTOList(List<Curso> entities) {
        if (entities == null) {
            return null;
        }
        
        return entities.stream()
                .map(CursoMapper::toDTO)
                .collect(Collectors.toList());
    }
}