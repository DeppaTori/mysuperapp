package com.deppatori.mysuperapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.deppatori.mysuperapp.model.Buku;

public interface BukuRepository extends MongoRepository<Buku, String>{
	Buku findBy_id(ObjectId _id);
}
