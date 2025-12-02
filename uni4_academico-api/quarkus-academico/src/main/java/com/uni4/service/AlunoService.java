package com.uni4.service;

import com.uni4.entity.Aluno;
import com.uni4.repository.AlunoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AlunoService {

    @Inject
    AlunoRepository alunoRepository;

    public List<Aluno> listAll() {
        return alunoRepository.listAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id);
    }

    @Transactional
    public void create(Aluno aluno) {
        alunoRepository.persist(aluno);
    }

    @Transactional
    public void update(Long id, Aluno aluno) {
        Aluno entity = alunoRepository.findById(id);
        if (entity != null) {
            entity.setNome(aluno.getNome());
            entity.setEmail(aluno.getEmail());
            entity.setDataCadastro(aluno.getDataCadastro());
            entity.setHoraCadastro(aluno.getHoraCadastro());
            entity.setKeycloakId(aluno.getKeycloakId());
            entity.setDeleteAt(aluno.getDeleteAt());
        }
    }

    @Transactional
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}