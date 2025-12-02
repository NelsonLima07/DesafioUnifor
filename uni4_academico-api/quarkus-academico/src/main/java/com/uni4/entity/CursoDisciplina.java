package com.uni4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "curso_disciplina")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datacadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "horacadastro", nullable = false)
    private LocalTime horaCadastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false,
                foreignKey = @ForeignKey(name = "fk_curso_disciplina_curso"))
    private Curso curso;

    @Column(name = "disciplina", length = 60, nullable = false)
    private String disciplina;

    @Column(name = "numsemestre", nullable = false)
    private Integer numSemestre;
}