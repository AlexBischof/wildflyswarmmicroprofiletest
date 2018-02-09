package de.bischinger.microprofile;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN_TYPE;
import static javax.ws.rs.core.Response.Status;
import static javax.ws.rs.core.Response.status;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException e) {
        return
                status(Status.OK)
                .entity("This is our exception page!")
                .type(TEXT_PLAIN_TYPE)
                .build();
    }
}