package com.uni4.resource;

import com.uni4.dto.LoginRequestDTO;
import com.uni4.dto.LogoutRequestDTO;
import com.uni4.dto.TokenDTO;
import com.uni4.service.KeycloakService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    KeycloakService keycloakService;

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
}