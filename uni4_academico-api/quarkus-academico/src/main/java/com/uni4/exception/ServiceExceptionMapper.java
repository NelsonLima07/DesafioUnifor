package com.uni4.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<WebApplicationException> {

    private static final Logger LOG = Logger.getLogger(ServiceExceptionMapper.class);

    @Override
    public Response toResponse(WebApplicationException exception) {
        LOG.error("Erro ao consumir API de microserviço: " + exception.getMessage(), exception);

        // Se a exceção já tem um Response, podemos reaproveitar
        if (exception.getResponse() != null) {
            return Response.status(exception.getResponse().getStatus())
                    .entity("Falha ao comunicar com microserviço. Status: " + exception.getResponse().getStatus())
                    .build();
        }

        return Response.status(Response.Status.BAD_GATEWAY)
                .entity("Erro ao consumir microserviço. Tente novamente mais tarde.")
                .build();
    }
}