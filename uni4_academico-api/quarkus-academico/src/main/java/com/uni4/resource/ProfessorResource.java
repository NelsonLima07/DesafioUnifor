package com.uni4.resource;

import com.uni4.dto.ProfessorDTO;
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

    //Listar todos (retorna DTOs)
    @GET
    public List<ProfessorDTO> listAll() {
        return professorService.listAll();
    }

    //Buscar por ID (retorna DTO)
    @GET
    @Path("/{id}")
    public ProfessorDTO findById(@PathParam("id") Long id) {
        return professorService.findById(id);
    }

    //Criar novo curso (recebe DTO e retorna DTO)
    @POST
    public Response create(ProfessorDTO dto) {
        ProfessorDTO obj = professorService.create(dto);
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    //Atualizar curso existente (recebe DTO e retorna DTO)
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ProfessorDTO dto) {
        ProfessorDTO obj = professorService.update(id, dto);
        return Response.ok(obj).build();
    }

    //Deletar curso
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        professorService.delete(id);
        return Response.noContent().build();
    }
}