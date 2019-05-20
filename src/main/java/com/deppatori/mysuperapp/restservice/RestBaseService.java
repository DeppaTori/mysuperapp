package com.deppatori.mysuperapp.restservice;

import java.util.Set;

import javax.ws.rs.*;
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

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public T create(T t){
		return getService().save(t);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public T update(@PathParam("id") ObjectId id,T t){
		return getService().update(id,t);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void delete(@PathParam("id") ObjectId id){
		getService().delete(id);
	}
	
	public abstract BaseService<T> getService();
	
}
