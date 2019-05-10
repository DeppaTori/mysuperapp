package com.deppatori.mysuperapp.service;

import java.util.Set;

import org.bson.types.ObjectId;

import com.deppatori.mysuperapp.model.BaseModel;

public interface BaseService<T extends BaseModel>{
	public Set<T> findAll();
	public T findOne(ObjectId _id);
	public T save(T t);
	public T update(ObjectId _id,T t);
	public void delete(ObjectId _id);
}
