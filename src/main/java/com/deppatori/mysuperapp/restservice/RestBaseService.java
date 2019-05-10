package com.deppatori.mysuperapp.restservice;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.deppatori.mysuperapp.model.BaseModel;
import com.deppatori.mysuperapp.service.BaseService;

public abstract class RestBaseService<T extends BaseModel> {

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<T> getAll(){
		return getService().findAll();
	}
	
	public abstract BaseService<T> getService();
	
}
