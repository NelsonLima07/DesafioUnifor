package com.uni4.repository;

import com.uni4.entity.AlunoCurso;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlunoCursoRepository implements PanacheRepository<AlunoCurso> {

    public AlunoCurso findByMatricula(Integer matricula) {
        return find("matricula", matricula).firstResult();
    }

    public boolean existsByAlunoAndCurso(Long alunoId, Long cursoId) {
        return find("aluno.id = ?1 and curso.id = ?2", alunoId, cursoId).count() > 0;
    }
}