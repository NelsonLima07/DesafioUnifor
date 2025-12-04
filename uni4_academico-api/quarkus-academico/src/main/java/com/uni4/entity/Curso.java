package com.uni4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datacadastro", insertable = false, updatable = false)
    private LocalDate dataCadastro;

    @Column(name = "horacadastro", insertable = false, updatable = false)
    private LocalTime horaCadastro;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "qtdsemestres", nullable = false)
    private Integer qtdSemestres;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlunoCurso> alunos;

}