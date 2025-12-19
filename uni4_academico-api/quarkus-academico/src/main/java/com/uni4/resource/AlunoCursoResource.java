package com.uni4.resource;

import com.uni4.entity.AlunoCurso;
import com.uni4.service.AlunoCursoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.uni4.dto.CursoDTO;

import java.util.List;

@Path("/aluno-curso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoCursoResource {

    @Inject
    AlunoCursoService alunoCursoService;

    // 🔹 Listar todos
    @GET
    public List<AlunoCurso> listAll() {
        return alunoCursoService.listAll();
    }

    //Buscar por ID
    @GET
    @Path("/{id}")
    public AlunoCurso findById(@PathParam("id") Long id) {
        return alunoCursoService.findById(id);
    }

    // Buscar cursos por ID do aluno
    @GET
    @Path("/{idAluno}/cursos")
    @Transactional
    public List<CursoDTO> findByAlunoId(@PathParam("idAluno") Long idAluno) {
        return alunoCursoService.findByAlunoId(idAluno);
    }

    //Criar novo registro
    @POST
    public Response create(AlunoCurso alunoCurso) {
        alunoCursoService.create(alunoCurso);
        return Response.status(Response.Status.CREATED).entity(alunoCurso).build();
    }

    //Atualizar registro existente
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, AlunoCurso alunoCurso) {
        alunoCursoService.update(id, alunoCurso);
        return Response.ok(alunoCurso).build();
    }

    //Deletar registro
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        alunoCursoService.delete(id);
        return Response.noContent().build();
    }
}