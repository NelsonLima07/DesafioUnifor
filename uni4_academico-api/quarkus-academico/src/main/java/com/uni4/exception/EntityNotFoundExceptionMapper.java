package com.uni4.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<jakarta.persistence.EntityNotFoundException> {

    private static final Logger LOG = Logger.getLogger(EntityNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(jakarta.persistence.EntityNotFoundException exception) {
        LOG.warn("Entidade não encontrada: " + exception.getMessage());

        return Response.status(Response.Status.NOT_FOUND)
                .entity("Recurso não encontrado.")
                .build();
    }
}