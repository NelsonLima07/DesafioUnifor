package com.uni4.repository;

import com.uni4.entity.Curso;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CursoRepository implements PanacheRepository<Curso> {

    public Curso findByNome(String nome) {
        return find("nome", nome).firstResult();
    }

    public boolean existsByNome(String nome) {
        return find("nome", nome).count() > 0;
    }
}