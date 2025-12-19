package com.uni4.repository;

import com.uni4.dto.HistoricoDTO;
import com.uni4.entity.SemestreAluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<HistoricoDTO> buscarHistoricoDTO(Long idAluno){
        String sql = """
            SELECT sa.id, s.numsemestre, s.ano,  c.nome AS curso, cd.disciplina, p.nome, sa.cod_status, sa.nota, sa.faltas
            FROM semestre_aluno sa
            INNER JOIN semestre s ON (sa.id_semestre = s.id)
            INNER JOIN aluno_curso ac ON (sa.id_alunocurso = ac.id AND ac.id_aluno = :idAluno)
            INNER JOIN curso_disciplina cd ON (sa.id_disciplina = cd.id)
            INNER JOIN curso c ON (cd.id_curso = c.id)
            INNER JOIN professor p ON (sa.id_professor = p.id)
            ORDER BY s.ano, s.numsemestre, c.nome, cd.disciplina
            """;

        @SuppressWarnings("unchecked")
        List<Object[]> resultados = getEntityManager().createNativeQuery(sql).setParameter("idAluno", idAluno).getResultList();

        return resultados.stream().map(row -> new HistoricoDTO(
            
                ((Number) row[0]).longValue(),  //id 
                (Integer) row[1], //s.numsemestre
                (Integer) row[2], // s.ano
                (String) row[3],  // c.nome curso
                (String) row[4],  // cd.disciplina
                (String) row[5], // p.nome
                (Integer) row[6], // sa.cod_status
                ((BigDecimal) row[7]).doubleValue(),  //sa.nota
                (Integer) row[8] // sa.faltas
        )).collect(Collectors.toList());
    }


}