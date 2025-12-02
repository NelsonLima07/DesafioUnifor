package com.uni4.repository;

import com.uni4.entity.Coordenador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CoordenadorRepository implements PanacheRepository<Coordenador> {

    public Coordenador findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public boolean existsByKeycloakId(Integer keycloakId) {
        return find("keycloakId", keycloakId).count() > 0;
    }
}