package com.uni4.service;

import com.uni4.dto.LoginRequest;
import com.uni4.dto.TokenResponse;
import com.uni4.dto.UserRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

@ApplicationScoped
public class KeycloakService {

    private static final String KEYCLOAK_SERVER = "http://localhost:8080";
    private static final String REALM = "uni4_academico";
    private static final String CLIENT_ID = "uni4-academico-api";
    private static final String CLIENT_SECRET = "unifor";

    private static final String TOKEN_URL = KEYCLOAK_SERVER + "/realms/" + REALM + "/protocol/openid-connect/token";
    private static final String LOGOUT_URL = KEYCLOAK_SERVER + "/realms/" + REALM + "/protocol/openid-connect/logout";
    private static final String ADMIN_USERS_URL = KEYCLOAK_SERVER + "/admin/realms/" + REALM + "/users";

    //Login
    public TokenResponse login(LoginRequest loginRequest) {
        Client client = ClientBuilder.newClient();

        Form form = new Form();
        form.param("grant_type", "password");
        form.param("client_id", CLIENT_ID);
        form.param("client_secret", CLIENT_SECRET);
        form.param("username", loginRequest.getUsername());
        form.param("password", loginRequest.getPassword());

        Response response = client.target(TOKEN_URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.form(form));

        if (response.getStatus() == 200) {
            return response.readEntity(TokenResponse.class);
        } else {
            throw new RuntimeException("Erro ao autenticar no Keycloak: " + response.getStatus());
        }
    }

    //Logout
    public void logout(String refreshToken) {
        Client client = ClientBuilder.newClient();

        Form form = new Form();
        form.param("client_id", CLIENT_ID);
        form.param("client_secret", CLIENT_SECRET);
        form.param("refresh_token", refreshToken);

        Response response = client.target(LOGOUT_URL)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.form(form));

        if (response.getStatus() != 204) {
            throw new RuntimeException("Erro ao realizar logout no Keycloak: " + response.getStatus());
        }
    }

    //Criar usuário
    public String createUser(UserRequest userRequest, String adminToken) {
        Client client = ClientBuilder.newClient();
        ObjectMapper mapper = new ObjectMapper();

        // Monta JSON do usuário
        ObjectNode userJson = mapper.createObjectNode();
        userJson.put("username", userRequest.getUsername());
        userJson.put("email", userRequest.getEmail());
        userJson.put("enabled", true);

        ObjectNode credential = mapper.createObjectNode();
        credential.put("type", "password");
        credential.put("value", userRequest.getPassword());
        credential.put("temporary", false);

        ArrayNode credentials = mapper.createArrayNode();
        credentials.add(credential);

        userJson.set("credentials", credentials);

        Response response = client.target(ADMIN_USERS_URL)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + adminToken)
                .post(Entity.json(userJson.toString()));

        if (response.getStatus() == 201) {
            String location = response.getHeaderString("Location");
            return location.substring(location.lastIndexOf("/") + 1);
        } else {
            throw new RuntimeException("Erro ao criar usuário no Keycloak: " + response.getStatus());
        }
    }
}