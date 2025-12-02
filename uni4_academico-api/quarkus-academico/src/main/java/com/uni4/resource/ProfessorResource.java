package com.uni4.resource;

import com.uni4.entity.Professor;
import com.uni4.service.ProfessorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/professores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorResource {

    @Inject
    ProfessorService professorService;

    // 🔹 Listar todos
    @GET
    public List<Professor> listAll() {
        return professorService.listAll();
    }

    // 🔹 Buscar por ID
    @GET
    @Path("/{id}")
    public Professor findById(@PathParam("id") Long id) {
        return professorService.findById(id);
    }

    // 🔹 Criar novo professor
    @POST
    public Response create(Professor professor) {
        professorService.create(professor);
        return Response.status(Response.Status.CREATED).entity(professor).build();
    }

    // 🔹 Atualizar professor existente
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Professor professor) {
        professorService.update(id, professor);
        return Response.ok(professor).build();
    }

    // 🔹 Deletar professor
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        professorService.delete(id);
        return Response.noContent().build();
    }
}