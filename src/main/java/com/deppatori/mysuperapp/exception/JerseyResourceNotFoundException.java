package com.deppatori.mysuperapp.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JerseyResourceNotFoundException implements ExceptionMapper<ResourceNotFoundException>{
	public Response toResponse(ResourceNotFoundException e) {
	      return Response.status(Response.Status.NOT_FOUND).build();
	}
}
