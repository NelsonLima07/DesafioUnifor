package com.uni4.client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import com.uni4.dto.TokenDTO;
import com.uni4.dto.UserKeycloakDTO;

@RegisterRestClient(configKey = "keycloak")
public interface KeycloakClient {

    static final String TOKEN_URL = "";
    static final String LOGIN_URL = "";
    static final String LOGOUT_URL = "";

    // Pegar token do login
    @POST
    @Path("/realms/uni4_academico/protocol/openid-connect/token")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    TokenDTO getTokenLogin(
        @FormParam("client_id") String clientId,
        @FormParam("username") String username,
        @FormParam("password") String password,
        @FormParam("grant_type") String grantType
    );

    // Pegar token de adm
    @POST
    @Path("/realms/uni4_academico/protocol/openid-connect/token")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    TokenDTO getTokenAdm(
        @FormParam("client_id") String clientId,
        @FormParam("client_secret") String clientSecret,
        @FormParam("grant_type") String grantType
    );

    // Criar usuario no Keycloak
    @POST
    @Path("/admin/realms/uni4_academico/users")
    @Consumes("application/json")
    @Produces("application/json")
    Response createUser(@HeaderParam("Authorization") String authorization, UserKeycloakDTO keycloakDTO);



}