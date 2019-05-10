package com.deppatori.mysuperapp.repository;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.deppatori.mysuperapp.model.BaseModel;

public interface BaseRepository<T extends BaseModel,String> extends MongoRepository<T,Serializable>{
	T findBy_id(ObjectId _id);
}
