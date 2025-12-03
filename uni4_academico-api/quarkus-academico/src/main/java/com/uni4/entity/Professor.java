package com.uni4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "professor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datacadastro", insertable = false, updatable = false)
    private LocalDate dataCadastro;

    @Column(name = "horacadastro", insertable = false, updatable = false)
    private LocalTime horaCadastro;

    @Column(name = "nome", length = 120, nullable = false)
    private String nome;

    @Column(name = "email", length = 80, nullable = false)
    private String email;

    @Column(name = "keycloak_id", nullable = false)
    private UUID keycloakId;
}