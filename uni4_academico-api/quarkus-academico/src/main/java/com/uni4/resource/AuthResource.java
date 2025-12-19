package com.uni4.resource;

import com.uni4.dto.LoginRequestDTO;
import com.uni4.dto.LogoutRequestDTO;
import com.uni4.dto.TokenDTO;
import com.uni4.service.KeycloakService;
import com.uni4.service.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.uni4.dto.UsuarioRequestDTO;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    KeycloakService keycloakService;

    @Inject
    UserService userService;

    @POST
    @Path("/login")
    public Response login(LoginRequestDTO loginRequestDTO) {
        try {
            TokenDTO token = keycloakService.login(loginRequestDTO);
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Login falhou: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Path("/logout")
    public Response logout(LogoutRequestDTO logoutRequestDTO) {
        return Response.ok(logoutRequestDTO).build();
    }

    @POST
    @Path("/getUserID")
    public Response getUserID(UsuarioRequestDTO usuarioRequestDTO) {
        
        if (usuarioRequestDTO.keycloakId() == null || usuarioRequestDTO.role() == null) {
             return Response.status(Response.Status.BAD_REQUEST)
                .entity("UUID e tipoUsuario são obrigatórios.").build();
        }

        try {
            Long internalId = userService.getUserIdByUuid(usuarioRequestDTO);
            
            if (internalId != null) {
                return Response.ok(internalId).build(); 
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado para o tipo e UUID fornecidos.").build();
            }
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage()).build();
        } catch (Exception e) {
             return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Erro interno do servidor ao buscar ID." +  e.getMessage()).build();
        }
    }

}