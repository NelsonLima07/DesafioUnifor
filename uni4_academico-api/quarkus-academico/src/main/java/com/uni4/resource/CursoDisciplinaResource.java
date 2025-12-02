package com.uni4.resource;

import com.uni4.entity.CursoDisciplina;
import com.uni4.service.CursoDisciplinaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/curso-disciplinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoDisciplinaResource {

    @Inject
    CursoDisciplinaService cursoDisciplinaService;

    // 🔹 Listar todos
    @GET
    public List<CursoDisciplina> listAll() {
        return cursoDisciplinaService.listAll();
    }

    // 🔹 Buscar por ID
    @GET
    @Path("/{id}")
    public CursoDisciplina findById(@PathParam("id") Long id) {
        return cursoDisciplinaService.findById(id);
    }

    // 🔹 Criar novo registro
    @POST
    public Response create(CursoDisciplina cursoDisciplina) {
        cursoDisciplinaService.create(cursoDisciplina);
        return Response.status(Response.Status.CREATED).entity(cursoDisciplina).build();
    }

    // 🔹 Atualizar registro existente
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CursoDisciplina cursoDisciplina) {
        cursoDisciplinaService.update(id, cursoDisciplina);
        return Response.ok(cursoDisciplina).build();
    }

    // 🔹 Deletar registro
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        cursoDisciplinaService.delete(id);
        return Response.noContent().build();
    }
}