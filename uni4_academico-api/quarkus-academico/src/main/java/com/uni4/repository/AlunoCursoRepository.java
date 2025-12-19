package com.uni4.repository;

import com.uni4.entity.AlunoCurso;
import com.uni4.entity.Curso;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AlunoCursoRepository implements PanacheRepository<AlunoCurso> {

    public AlunoCurso findByMatricula(Integer matricula) {
        return find("matricula", matricula).firstResult();
    }

    public boolean existsByAlunoAndCurso(Long alunoId, Long cursoId) {
        return find("aluno.id = ?1 and curso.id = ?2", alunoId, cursoId).count() > 0;
    }

    public List<Curso> findByAlunoId(Long idAluno) {
        String query = "SELECT ac.curso FROM AlunoCurso ac WHERE ac.aluno.id = ?1";
        return getEntityManager().createQuery(query, Curso.class)
                .setParameter(1, idAluno)
                .getResultList();
    }
    
}