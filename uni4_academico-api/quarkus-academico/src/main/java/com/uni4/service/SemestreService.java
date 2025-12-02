package com.uni4.service;

import com.uni4.entity.Semestre;
import com.uni4.repository.SemestreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class SemestreService {

    @Inject
    SemestreRepository semestreRepository;

    public List<Semestre> listAll() {
        return semestreRepository.listAll();
    }

    public Semestre findById(Long id) {
        return semestreRepository.findById(id);
    }

    @Transactional
    public void create(Semestre semestre) {
        semestreRepository.persist(semestre);
    }

    @Transactional
    public void update(Long id, Semestre semestre) {
        Semestre entity = semestreRepository.findById(id);
        if (entity != null) {
            entity.setNumSemestre(semestre.getNumSemestre());
            entity.setAno(semestre.getAno());
            entity.setCoordenador(semestre.getCoordenador());
            entity.setDataCadastro(semestre.getDataCadastro());
            entity.setHoraCadastro(semestre.getHoraCadastro());
        }
    }

    @Transactional
    public void delete(Long id) {
        semestreRepository.deleteById(id);
    }
}