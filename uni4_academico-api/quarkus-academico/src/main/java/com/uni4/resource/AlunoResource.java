package com.uni4.resource;

import com.uni4.entity.Aluno;
import com.uni4.service.AlunoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoResource {

    @Inject
    AlunoService alunoService;

    @GET
    public List<Aluno> listAll() {
        return alunoService.listAll();
    }

    @GET
    @Path("/{id}")
    public Aluno findById(@PathParam("id") Long id) {
        return alunoService.findById(id);
    }

    @POST
    public Response create(Aluno aluno) {
        alunoService.create(aluno);
        return Response.status(Response.Status.CREATED).entity(aluno).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Aluno aluno) {
        alunoService.update(id, aluno);
        return Response.ok(aluno).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        alunoService.delete(id);
        return Response.noContent().build();
    }
}