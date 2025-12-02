package com.uni4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "aluno_curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datacadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "horacadastro", nullable = false)
    private LocalTime horaCadastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno", nullable = false,
                foreignKey = @ForeignKey(name = "fk_aluno_curso_aluno"))
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false,
                foreignKey = @ForeignKey(name = "fk_aluno_curso_curso"))
    private Curso curso;

    @Column(name = "matricula", nullable = false)
    private Integer matricula;

    @Builder.Default
    @Column(name = "numsemestre", nullable = false)
    private Integer numSemestre = 1;
}