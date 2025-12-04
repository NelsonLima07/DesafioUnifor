package com.uni4.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    private static final Logger LOG = Logger.getLogger(IllegalArgumentExceptionMapper.class);

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        LOG.error("Erro de validação: " + exception.getMessage(), exception);

        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Dados inválidos: " + exception.getMessage())
                .build();
    }
}