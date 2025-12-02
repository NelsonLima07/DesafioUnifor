package com.uni4.repository;

import com.uni4.entity.Professor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor> {

    public Professor findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public boolean existsByKeycloakId(Integer keycloakId) {
        return find("keycloakId", keycloakId).count() > 0;
    }
}