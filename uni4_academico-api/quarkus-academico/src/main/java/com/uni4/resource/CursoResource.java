package com.uni4.resource;

import com.uni4.entity.Curso;
import com.uni4.service.CursoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoResource {

    @Inject
    CursoService cursoService;

    // 🔹 Listar todos
    @GET
    public List<Curso> listAll() {
        return cursoService.listAll();
    }

    // 🔹 Buscar por ID
    @GET
    @Path("/{id}")
    public Curso findById(@PathParam("id") Long id) {
        return cursoService.findById(id);
    }

    // 🔹 Criar novo curso
    @POST
    public Response create(Curso curso) {
        cursoService.create(curso);
        return Response.status(Response.Status.CREATED).entity(curso).build();
    }

    // 🔹 Atualizar curso existente
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Curso curso) {
        cursoService.update(id, curso);
        return Response.ok(curso).build();
    }

    // 🔹 Deletar curso
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        cursoService.delete(id);
        return Response.noContent().build();
    }
}