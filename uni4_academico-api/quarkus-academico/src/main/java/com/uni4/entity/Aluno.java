package com.uni4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "aluno")
@Data                   
@NoArgsConstructor      
@AllArgsConstructor     
@Builder                
public class Aluno {

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

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AlunoCurso> cursos;

}