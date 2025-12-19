package com.uni4.service;

import com.uni4.dto.ProfessorDTO;
import com.uni4.entity.Professor;
import com.uni4.mapper.ProfessorMapper;
import com.uni4.repository.ProfessorRepository;
import com.uni4.client.KeycloakClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.uni4.dto.UserKeycloakDTO;
import com.uni4.service.KeycloakService;



import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.jboss.logging.Logger;


@ApplicationScoped
public class ProfessorService {
    private static final Logger LOG = Logger.getLogger(ProfessorService.class);

    private final ProfessorRepository professorRepository;
    private final KeycloakClient keycloakClient;
/*
    @Inject
    ProfessorRepository professorRepository;
*/  @Inject
    KeycloakService keycloakService;


    @Inject
    public ProfessorService(ProfessorRepository professorRepository, @RestClient KeycloakClient keycloakClient) {
        this.professorRepository = professorRepository;
        this.keycloakClient = keycloakClient;
    }


    public List<ProfessorDTO> listAll() {
        return professorRepository.findAll()
                .stream()
                .map(ProfessorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO findById(Long id) {
        Professor obj = professorRepository.findById(id);
        return ProfessorMapper.toDTO(obj);
    }

    @Transactional
    public ProfessorDTO create(ProfessorDTO dto) {
        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new IllegalArgumentException("[CursoDTO:create] nome não pode ser nulo ou vazio");
        }
        if (dto.email() == null || dto.email().isBlank()) {
            throw new IllegalArgumentException("[CursoDTO:create] email não pode ser nulo ou vazio");
        }
        
        String keycloakUuid = "550e8400-e29b-41d4-a716-446655440000";
        /*
        String keycloakUuid;
        try {
            keycloakUuid = keycloakService.createUser(user);
            LOG.info("Usuário criado no Keycloak com UUID: " + keycloakUuid);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar usuário no Keycloak: " + e.getMessage(), e);
        }
        */

        ProfessorDTO dtoComKeycloak = new ProfessorDTO(
            dto.id(),
            dto.nome(),
            dto.email(),
            UUID.fromString(keycloakUuid)
        );
        

        Professor obj = ProfessorMapper.toEntity(dtoComKeycloak);
        professorRepository.persist(obj);
        return ProfessorMapper.toDTO(obj);
        
    }

    @Transactional
    public ProfessorDTO update(Long id, ProfessorDTO dto) {
        Professor obj = professorRepository.findById(id);
        obj.setNome(dto.nome());
        obj.setEmail(dto.email());

        return ProfessorMapper.toDTO(obj);
    }

    @Transactional
    public void delete(Long id) {
        Professor curso = professorRepository.findById(id);
        professorRepository.delete(curso);
    }
}