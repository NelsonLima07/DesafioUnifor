package com.uni4.service;

import com.uni4.entity.Coordenador;
import com.uni4.repository.CoordenadorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CoordenadorService {

    @Inject
    CoordenadorRepository coordenadorRepository;

    public List<Coordenador> listAll() {
        return coordenadorRepository.listAll();
    }

    public Coordenador findById(Long id) {
        return coordenadorRepository.findById(id);
    }

    @Transactional
    public void create(Coordenador coordenador) {
        coordenadorRepository.persist(coordenador);
    }

    @Transactional
    public void update(Long id, Coordenador coordenador) {
        Coordenador entity = coordenadorRepository.findById(id);
        if (entity != null) {
            entity.setNome(coordenador.getNome());
            entity.setEmail(coordenador.getEmail());
            entity.setDataCadastro(coordenador.getDataCadastro());
            entity.setHoraCadastro(coordenador.getHoraCadastro());
            entity.setKeycloakId(coordenador.getKeycloakId());
        }
    }

    @Transactional
    public void delete(Long id) {
        coordenadorRepository.deleteById(id);
    }
}