package com.uni4.service;

import com.uni4.dto.CursoDTO;
import com.uni4.entity.Curso;
import com.uni4.mapper.CursoMapper;
import com.uni4.repository.CursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CursoService {

    @Inject
    CursoRepository cursoRepository;

    public List<CursoDTO> listAll() {
        return cursoRepository.findAll()
                .stream()
                .map(CursoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CursoDTO findById(Long id) {
        Curso curso = cursoRepository.findById(id);
        return CursoMapper.toDTO(curso);
    }

    @Transactional
    public CursoDTO create(CursoDTO dto) {
        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new IllegalArgumentException("[CursoDTO:create] nome não pode ser nulo ou vazio");
        }
        Curso curso = CursoMapper.toEntity(dto);
        cursoRepository.persist(curso);
        return CursoMapper.toDTO(curso);
    }

    @Transactional
    public CursoDTO update(Long id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id);
        curso.setNome(dto.nome());
        curso.setQtdSemestres(dto.qtdSemestres());

        return CursoMapper.toDTO(curso);
    }

    @Transactional
    public void delete(Long id) {
        Curso curso = cursoRepository.findById(id);
        cursoRepository.delete(curso);
    }
}