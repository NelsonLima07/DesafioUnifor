package com.uni4.resource;

import com.uni4.dto.CursoDTO;
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

    //Listar todos (retorna DTOs)
    @GET
    public List<CursoDTO> listAll() {
        return cursoService.listAll();
    }

    //Buscar por ID (retorna DTO)
    @GET
    @Path("/{id}")
    public CursoDTO findById(@PathParam("id") Long id) {
        return cursoService.findById(id);
    }

    //Criar novo curso (recebe DTO e retorna DTO)
    @POST
    public Response create(CursoDTO dto) {
        CursoDTO obj = cursoService.create(dto);
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    //Atualizar curso existente (recebe DTO e retorna DTO)
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CursoDTO dto) {
        CursoDTO obj = cursoService.update(id, dto);
        return Response.ok(obj).build();
    }

    //Deletar curso
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        cursoService.delete(id);
        return Response.noContent().build();
    }
}