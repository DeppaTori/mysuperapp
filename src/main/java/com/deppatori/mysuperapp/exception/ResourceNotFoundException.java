package com.deppatori.mysuperapp.exception;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String entity, ObjectId _id) {
		super(entity+" not found :"+_id.toHexString());
		
	}
	
	
	
	
}
