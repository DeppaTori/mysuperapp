package com.deppatori.mysuperapp.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyException implements ExceptionMapper<ExceptionName>{

	@Override
	public Response toResponse(ExceptionName exception) {
		return Response.status(exception.getCode()).entity(exception.getMessage()).build();
	}

}
