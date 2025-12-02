package com.uni4.repository;

import com.uni4.entity.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {

        public Aluno findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public boolean existsByKeycloakId(Integer keycloakId) {
        return find("keycloakId", keycloakId).count() > 0;
    }

    public Aluno findActiveById(Long id) {
        return find("id = ?1 and deleteAt is null", id).firstResult();
    }
}