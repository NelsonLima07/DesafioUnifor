package com.uni4.repository;

import com.uni4.entity.SemestreAluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SemestreAlunoRepository implements PanacheRepository<SemestreAluno> {

    public List<SemestreAluno> findByAlunoCurso(Long alunoCursoId) {
        return list("alunoCurso.id", alunoCursoId);
    }

    public List<SemestreAluno> findBySemestre(Long semestreId) {
        return list("semestre.id", semestreId);
    }

    public List<SemestreAluno> findByProfessor(Long professorId) {
        return list("professor.id", professorId);
    }
}