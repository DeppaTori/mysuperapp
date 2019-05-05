package com.deppatori.mysuperapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.deppatori.mysuperapp.model.Produk;

public interface ProdukRepository extends MongoRepository<Produk, String> {
	Produk findBy_id(ObjectId _id);
}
