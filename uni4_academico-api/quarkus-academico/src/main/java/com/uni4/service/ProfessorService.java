package com.uni4.service;

import com.uni4.entity.Professor;
import com.uni4.repository.ProfessorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProfessorService {

    @Inject
    ProfessorRepository professorRepository;

    public List<Professor> listAll() {
        return professorRepository.listAll();
    }

    public Professor findById(Long id) {
        return professorRepository.findById(id);
    }

    @Transactional
    public void create(Professor professor) {
        professorRepository.persist(professor);
    }

    @Transactional
    public void update(Long id, Professor professor) {
        Professor entity = professorRepository.findById(id);
        if (entity != null) {
            entity.setNome(professor.getNome());
            entity.setEmail(professor.getEmail());
            entity.setDataCadastro(professor.getDataCadastro());
            entity.setHoraCadastro(professor.getHoraCadastro());
            entity.setKeycloakId(professor.getKeycloakId());
        }
    }

    @Transactional
    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
}