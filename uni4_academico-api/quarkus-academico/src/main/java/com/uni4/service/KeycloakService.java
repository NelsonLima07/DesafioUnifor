package com.uni4.service;

import com.uni4.client.KeycloakClient;
import com.uni4.dto.LoginRequestDTO;
import com.uni4.dto.LogoutRequestDTO;
import com.uni4.dto.TokenDTO;
import com.uni4.dto.UserKeycloakDTO;

import io.vertx.codegen.doc.Token;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class KeycloakService {

    private static final String REALM = "uni4_academico";
    //private static final String CLIENT_ID = "uni4-academico-api";
    private static final String CLIENT_ID = "admin-cli";
    private static final String CLIENT_SECRET = "uni4";
    
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "admin";

    @Inject
    @RestClient
    KeycloakClient keycloakClient;

    public String getAdminToken() {
        TokenDTO token = keycloakClient.getTokenAdm(
            CLIENT_ID,     
            CLIENT_SECRET, 
            "client_credentials"
        );
        return token.accessToken();
    }

    public String createUser(UserKeycloakDTO userKeycloakDTO) {
        
        //String adminToken = getAdminToken();
        TokenDTO adminToken = this.login(
            new LoginRequestDTO(ADMIN_USER, ADMIN_PASS)
        );
        
        
        Response response = keycloakClient.createUser("Bearer " + adminToken.accessToken(), userKeycloakDTO);
        // Pega o UUID do novo usuário
        String location = response.getHeaderString("Location");
        String uuid = location.substring(location.lastIndexOf("/") + 1);

        return uuid;
    }
    
    public TokenDTO login(LoginRequestDTO loginRequestDTO) {
        TokenDTO token = keycloakClient.getTokenLogin(
            CLIENT_ID,
            loginRequestDTO.username(),
            loginRequestDTO.password(),
            "password"
        );
        return token;
    }
}