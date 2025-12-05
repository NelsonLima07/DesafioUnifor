package com.uni4.dto;

import jakarta.ws.rs.FormParam;

public class LoginRequestKeycloakDTO {
    @FormParam("client_id")
    public String clientId;

    @FormParam("client_secret")
    public String clientSecret;

    @FormParam("username")
    public String username;

    @FormParam("password")
    public String password;

    @FormParam("grant_type")
    public String grantType;
}
