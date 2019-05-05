package com.deppatori.mysuperapp.service;

import java.util.Set;

import org.bson.types.ObjectId;

import com.deppatori.mysuperapp.model.Produk;

public interface ProdukService {
	public Set<Produk> findAll();
	public Produk findOne(ObjectId _id);
	public Produk save(Produk produk);
	public Produk update(ObjectId _id,Produk produk);
	public void delete(ObjectId _id);
}
