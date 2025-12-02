package com.uni4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "semestre_aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemestreAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datacadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "horacadastro", nullable = false)
    private LocalTime horaCadastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_semestre", nullable = false,
                foreignKey = @ForeignKey(name = "fk_semestre_aluno_semestre"))
    private Semestre semestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alunocurso", nullable = false,
                foreignKey = @ForeignKey(name = "fk_semestre_aluno_alunocurso"))
    private AlunoCurso alunoCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disciplina", nullable = false,
                foreignKey = @ForeignKey(name = "fk_semestre_aluno_disciplina"))
    private CursoDisciplina disciplina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor", nullable = false,
                foreignKey = @ForeignKey(name = "fk_semestre_aluno_professor"))
    private Professor professor;

    @Column(name = "cod_status", nullable = false)
    private Integer codStatus;

    @Column(name = "nota", precision = 3, scale = 1)
    private BigDecimal nota;

    @Column(name = "faltas")
    private Integer faltas;
}