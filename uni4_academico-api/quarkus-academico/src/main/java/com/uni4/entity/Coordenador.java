package com.uni4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "coordenador")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datacadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "horacadastro", nullable = false)
    private LocalTime horaCadastro;

    @Column(name = "nome", length = 120, nullable = false)
    private String nome;

    @Column(name = "email", length = 80, nullable = false)
    private String email;

    @Column(name = "keycloak_id", nullable = false)
    private Integer keycloakId;
}