package com.uni4.repository;

import com.uni4.entity.CursoDisciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CursoDisciplinaRepository implements PanacheRepository<CursoDisciplina> {

    public List<CursoDisciplina> findByCurso(Long cursoId) {
        return list("curso.id", cursoId);
    }

    public List<CursoDisciplina> findByNumSemestre(Integer numSemestre) {
        return list("numSemestre", numSemestre);
    }
}