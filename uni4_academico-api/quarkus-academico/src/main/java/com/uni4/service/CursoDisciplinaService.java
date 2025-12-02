package com.uni4.service;

import com.uni4.entity.CursoDisciplina;
import com.uni4.repository.CursoDisciplinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CursoDisciplinaService {

    @Inject
    CursoDisciplinaRepository cursoDisciplinaRepository;

    public List<CursoDisciplina> listAll() {
        return cursoDisciplinaRepository.listAll();
    }

    public CursoDisciplina findById(Long id) {
        return cursoDisciplinaRepository.findById(id);
    }

    @Transactional
    public void create(CursoDisciplina cursoDisciplina) {
        cursoDisciplinaRepository.persist(cursoDisciplina);
    }

    @Transactional
    public void update(Long id, CursoDisciplina cursoDisciplina) {
        CursoDisciplina entity = cursoDisciplinaRepository.findById(id);
        if (entity != null) {
            entity.setCurso(cursoDisciplina.getCurso());
            entity.setDisciplina(cursoDisciplina.getDisciplina());
            entity.setNumSemestre(cursoDisciplina.getNumSemestre());
            entity.setDataCadastro(cursoDisciplina.getDataCadastro());
            entity.setHoraCadastro(cursoDisciplina.getHoraCadastro());
        }
    }

    @Transactional
    public void delete(Long id) {
        cursoDisciplinaRepository.deleteById(id);
    }
}