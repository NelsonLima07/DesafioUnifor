package com.uni4.resource;

import com.uni4.entity.SemestreAluno;
import com.uni4.service.SemestreAlunoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/semestre-alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SemestreAlunoResource {

    @Inject
    SemestreAlunoService semestreAlunoService;

    // 🔹 Listar todos
    @GET
    public List<SemestreAluno> listAll() {
        return semestreAlunoService.listAll();
    }

    // 🔹 Buscar por ID
    @GET
    @Path("/{id}")
    public SemestreAluno findById(@PathParam("id") Long id) {
        return semestreAlunoService.findById(id);
    }

    // 🔹 Criar novo registro
    @POST
    public Response create(SemestreAluno semestreAluno) {
        semestreAlunoService.create(semestreAluno);
        return Response.status(Response.Status.CREATED).entity(semestreAluno).build();
    }

    // 🔹 Atualizar registro existente
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, SemestreAluno semestreAluno) {
        semestreAlunoService.update(id, semestreAluno);
        return Response.ok(semestreAluno).build();
    }

    // 🔹 Deletar registro
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        semestreAlunoService.delete(id);
        return Response.noContent().build();
    }
}