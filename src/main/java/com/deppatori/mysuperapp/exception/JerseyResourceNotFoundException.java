package com.deppatori.mysuperapp.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class JerseyResourceNotFoundException extends WebApplicationException{
	public JerseyResourceNotFoundException(ExceptionName exceptionName) {
		super(Response.status(Response.Status.NOT_FOUND)
				.entity(exceptionName.updateCode(404)).type(MediaType.APPLICATION_JSON).build());
	}
	
}
