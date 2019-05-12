package com.deppatori.mysuperapp.restservice;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;

import com.deppatori.mysuperapp.model.BaseModel;
import com.deppatori.mysuperapp.service.BaseService;

public abstract class RestBaseService<T extends BaseModel> {

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<T> getAll(){
		return getService().findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public T getOne(@PathParam("id") ObjectId id) {
		return getService().findOne(id);
	}
	
	public abstract BaseService<T> getService();
	
}
