package com.uni4.service;

import com.uni4.entity.AlunoCurso;
import com.uni4.repository.AlunoCursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AlunoCursoService {

    @Inject
    AlunoCursoRepository alunoCursoRepository;

    public List<AlunoCurso> listAll() {
        return alunoCursoRepository.listAll();
    }

    public AlunoCurso findById(Long id) {
        return alunoCursoRepository.findById(id);
    }

    @Transactional
    public void create(AlunoCurso alunoCurso) {
        alunoCursoRepository.persist(alunoCurso);
    }

    @Transactional
    public void update(Long id, AlunoCurso alunoCurso) {
        AlunoCurso entity = alunoCursoRepository.findById(id);
        if (entity != null) {
            entity.setDataCadastro(alunoCurso.getDataCadastro());
            entity.setHoraCadastro(alunoCurso.getHoraCadastro());
            entity.setAluno(alunoCurso.getAluno());
            entity.setCurso(alunoCurso.getCurso());
            entity.setMatricula(alunoCurso.getMatricula());
            entity.setNumSemestre(alunoCurso.getNumSemestre());
        }
    }

    @Transactional
    public void delete(Long id) {
        alunoCursoRepository.deleteById(id);
    }
}