package com.uni4.service;

import com.uni4.entity.SemestreAluno;
import com.uni4.repository.SemestreAlunoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class SemestreAlunoService {

    @Inject
    SemestreAlunoRepository semestreAlunoRepository;

    // **Listar todos**
    public List<SemestreAluno> listAll() {
        return semestreAlunoRepository.listAll();
    }

    // **Buscar por ID**
    public SemestreAluno findById(Long id) {
        return semestreAlunoRepository.findById(id);
    }

    // **Criar novo registro**
    @Transactional
    public void create(SemestreAluno semestreAluno) {
        semestreAlunoRepository.persist(semestreAluno);
    }

    // **Atualizar registro existente**
    @Transactional
    public void update(Long id, SemestreAluno semestreAluno) {
        SemestreAluno entity = semestreAlunoRepository.findById(id);
        if (entity != null) {
            entity.setSemestre(semestreAluno.getSemestre());
            entity.setAlunoCurso(semestreAluno.getAlunoCurso());
            entity.setDisciplina(semestreAluno.getDisciplina());
            entity.setProfessor(semestreAluno.getProfessor());
            entity.setCodStatus(semestreAluno.getCodStatus());
            entity.setNota(semestreAluno.getNota());
            entity.setFaltas(semestreAluno.getFaltas());
            entity.setDataCadastro(semestreAluno.getDataCadastro());
            entity.setHoraCadastro(semestreAluno.getHoraCadastro());
        }
    }

    // **Deletar registro**
    @Transactional
    public void delete(Long id) {
        semestreAlunoRepository.deleteById(id);
    }
}