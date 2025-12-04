package com.uni4.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    private static final Logger LOG = Logger.getLogger(GlobalExceptionMapper.class);

    @Override
    public Response toResponse(Exception exception) {
        
        LOG.error("Erro na API:", exception);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Ocorreu um erro inesperado. Tente novamente mais tarde ou contate o suporte.")
                .build();
    }
}