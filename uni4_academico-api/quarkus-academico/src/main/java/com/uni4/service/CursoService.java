package com.uni4.service;

import com.uni4.entity.Curso;
import com.uni4.repository.CursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CursoService {

    @Inject
    CursoRepository cursoRepository;

    public List<Curso> listAll() {
        return cursoRepository.listAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Transactional
    public void create(Curso curso) {
        cursoRepository.persist(curso);
    }

    @Transactional
    public void update(Long id, Curso curso) {
        Curso entity = cursoRepository.findById(id);
        if (entity != null) {
            entity.setNome(curso.getNome());
            entity.setQtdSemestres(curso.getQtdSemestres());
            entity.setDataCadastro(curso.getDataCadastro());
            entity.setHoraCadastro(curso.getHoraCadastro());
            entity.setDeleteAt(curso.getDeleteAt());
        }
    }

    @Transactional
    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}