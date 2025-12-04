package com.uni4.service;

import com.uni4.dto.AlunoDTO;
import com.uni4.entity.Aluno;
import com.uni4.mapper.AlunoMapper;
import com.uni4.repository.AlunoRepository;
import com.uni4.dto.TokenDTO;
import com.uni4.client.KeycloakClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.uni4.dto.UserKeycloakDTO;
import com.uni4.service.KeycloakService;



import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.jboss.logging.Logger;


@ApplicationScoped
public class AlunoService {
    private static final Logger LOG = Logger.getLogger(AlunoService.class);

    private final AlunoRepository alunoRepository;
    private final KeycloakClient keycloakClient;

    @Inject
    KeycloakService keycloakService;

    @Inject
    public ProfessorService(AlunoRepository alunoRepository, @RestClient KeycloakClient keycloakClient) {
        this.alunoRepository = alunoRepository;
        this.keycloakClient = keycloakClient;
    }


    public List<AlunoDTO> listAll() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AlunoDTO findById(Long id) {
        Aluno obj = alunoRepository.findById(id);
        return AlunoMapper.toDTO(obj);
    }

    @Transactional
    public AlunoDTO create(AlunoDTO dto) {
        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new IllegalArgumentException("[CursoDTO:create] nome não pode ser nulo ou vazio");
        }
        if (dto.email() == null || dto.email().isBlank()) {
            throw new IllegalArgumentException("[CursoDTO:create] email não pode ser nulo ou vazio");
        }
        
        String keycloakUuid = "550e8400-e29b-41d4-a716-446655440001";
        /*
        String keycloakUuid;
        try {
            keycloakUuid = keycloakService.createUser(user);
            LOG.info("Usuário criado no Keycloak com UUID: " + keycloakUuid);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar usuário no Keycloak: " + e.getMessage(), e);
        }
        */

        AlunoDTO dtoComKeycloak = new AlunoDTO(
            dto.id(),
            dto.nome(),
            dto.email(),
            UUID.fromString(keycloakUuid)
        );
        

        Aluno obj = AlunoMapper.toEntity(dtoComKeycloak);
        alunoRepository.persist(obj);
        return AlunoMapper.toDTO(obj);
        
    }

    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto) {
        Aluno obj = alunoRepository.findById(id);
        obj.setNome(dto.nome());
        obj.setEmail(dto.email());

        return AlunoMapper.toDTO(obj);
    }

    @Transactional
    public void delete(Long id) {
        Aluno curso = alunoRepository.findById(id);
        alunoRepository.delete(curso);
    }
}