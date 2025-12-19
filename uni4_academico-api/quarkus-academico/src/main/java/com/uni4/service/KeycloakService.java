package com.uni4.service;

import com.uni4.client.KeycloakClient;
import com.uni4.dto.LoginRequestDTO;
import com.uni4.dto.TokenDTO;
import com.uni4.dto.UserKeycloakDTO;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.uni4.dto.LoginRequestKeycloakDTO;


@ApplicationScoped
public class KeycloakService {

//    private static final String REALM = "uni4_academico";
    private static final String CLIENT_ID = "uni4-academico-api";
    private static final String CLIENT_SECRET = "uni4";
    
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "1234";

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
    
    // Pegar token do login
    public TokenDTO login(LoginRequestDTO loginRequestDTO) {
        LoginRequestKeycloakDTO req = new LoginRequestKeycloakDTO();
        req.clientId = CLIENT_ID;
        req.clientSecret = CLIENT_SECRET;
        req.username = loginRequestDTO.username();
        req.password = loginRequestDTO.password();
        req.grantType = "password";

        try {
            return  keycloakClient.getTokenLogin(req);
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == 400) {
                throw new NotAuthorizedException("Usuário ou senha inválidos.", e);
            }
            throw e;
        } catch (Exception e) {
            throw new WebApplicationException("Erro inesperado ao processar o login com Keycloak.",500); // Internal Server Error
        }
    }
}