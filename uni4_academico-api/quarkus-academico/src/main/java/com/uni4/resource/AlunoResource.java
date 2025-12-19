package com.uni4.resource;

import com.uni4.dto.AlunoDTO;
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

    //Listar todos (retorna DTOs)
    @GET
    public List<AlunoDTO> listAll() {
        return alunoService.listAll();
    }

    //Buscar por ID (retorna DTO)
    @GET
    @Path("/{id}")
    public AlunoDTO findById(@PathParam("id") Long id) {
        return alunoService.findById(id);
    }

    //Criar novo curso (recebe DTO e retorna DTO)
    @POST
    public Response create(AlunoDTO dto) {
        AlunoDTO obj = alunoService.create(dto);
        return Response.status(Response.Status.CREATED).entity(obj).build();
    }

    //Atualizar curso existente (recebe DTO e retorna DTO)
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, AlunoDTO dto) {
        AlunoDTO obj = alunoService.update(id, dto);
        return Response.ok(obj).build();
    }

    //Deletar curso
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        alunoService.delete(id);
        return Response.noContent().build();
    }
}