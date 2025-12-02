package com.uni4.resource;

import com.uni4.entity.Semestre;
import com.uni4.service.SemestreService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/semestres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SemestreResource {

    @Inject
    SemestreService semestreService;

    // 🔹 Listar todos
    @GET
    public List<Semestre> listAll() {
        return semestreService.listAll();
    }

    // 🔹 Buscar por ID
    @GET
    @Path("/{id}")
    public Semestre findById(@PathParam("id") Long id) {
        return semestreService.findById(id);
    }

    // 🔹 Criar novo semestre
    @POST
    public Response create(Semestre semestre) {
        semestreService.create(semestre);
        return Response.status(Response.Status.CREATED).entity(semestre).build();
    }

    // 🔹 Atualizar semestre existente
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Semestre semestre) {
        semestreService.update(id, semestre);
        return Response.ok(semestre).build();
    }

    // 🔹 Deletar semestre
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        semestreService.delete(id);
        return Response.noContent().build();
    }
}