package com.uni4.resource;

import com.uni4.entity.Coordenador;
import com.uni4.service.CoordenadorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/coordenadores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoordenadorResource {

    @Inject
    CoordenadorService coordenadorService;

    // 🔹 Listar todos
    @GET
    public List<Coordenador> listAll() {
        return coordenadorService.listAll();
    }

    // 🔹 Buscar por ID
    @GET
    @Path("/{id}")
    public Coordenador findById(@PathParam("id") Long id) {
        return coordenadorService.findById(id);
    }

    // 🔹 Criar novo registro
    @POST
    public Response create(Coordenador coordenador) {
        coordenadorService.create(coordenador);
        return Response.status(Response.Status.CREATED).entity(coordenador).build();
    }

    // 🔹 Atualizar registro existente
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Coordenador coordenador) {
        coordenadorService.update(id, coordenador);
        return Response.ok(coordenador).build();
    }

    // 🔹 Deletar registro
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        coordenadorService.delete(id);
        return Response.noContent().build();
    }
}