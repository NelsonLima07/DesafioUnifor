package com.uni4.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HomeResource {

    @GET
    public String home() {
        return "Aplicação Quarkus rodando! Valeu Nelson Lima!";
    }
}
