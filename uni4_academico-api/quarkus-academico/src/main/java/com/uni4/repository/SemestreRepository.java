package com.uni4.repository;

import com.uni4.entity.Semestre;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SemestreRepository implements PanacheRepository<Semestre> {

    public List<Semestre> findByAno(Integer ano) {
        return list("ano", ano);
    }

    public List<Semestre> findByCoordenador(Long coordenadorId) {
        return list("coordenador.id", coordenadorId);
    }
}