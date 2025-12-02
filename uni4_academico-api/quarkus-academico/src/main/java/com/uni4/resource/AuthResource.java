package com.uni4.resource;

import com.uni4.dto.LoginRequest;
import com.uni4.dto.TokenResponse;
import com.uni4.dto.UserRequest;
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

    // 🔹 Login
    @POST
    @Path("/login")
    public Response login(LoginRequest loginRequest) {
        try {
            TokenResponse tokenResponse = keycloakService.login(loginRequest);
            return Response.ok(tokenResponse).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Login falhou: " + e.getMessage())
                    .build();
        }
    }

    // 🔹 Logout
    @POST
    @Path("/logout")
    public Response logout(@QueryParam("refresh_token") String refreshToken) {
        try {
            keycloakService.logout(refreshToken);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Logout falhou: " + e.getMessage())
                    .build();
        }
    }

    // 🔹 Criar usuário
    @POST
    @Path("/create-user")
    public Response createUser(UserRequest userRequest, @HeaderParam("Authorization") String adminToken) {
        try {
            String userId = keycloakService.createUser(userRequest, adminToken.replace("Bearer ", ""));
            return Response.status(Response.Status.CREATED).entity("{\"id\":\"" + userId + "\"}").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erro ao criar usuário: " + e.getMessage())
                    .build();
        }
    }
}