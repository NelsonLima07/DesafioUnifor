package com.uni4.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Path("/now")
public class UtilsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> serverTime() {
        String time = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return Map.of("serverTime", time);
    }
}