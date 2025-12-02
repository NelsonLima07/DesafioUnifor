package com.uni4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    @Column(name = "datacadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "horacadastro", nullable = false)
    private LocalTime horaCadastro;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "qtdsemestres", nullable = false)
    private Integer qtdSemestres;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;
}