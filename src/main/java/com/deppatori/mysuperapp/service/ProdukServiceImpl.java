package com.deppatori.mysuperapp.service;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deppatori.mysuperapp.model.Produk;
import com.deppatori.mysuperapp.repository.BukuRepository;
import com.deppatori.mysuperapp.repository.ProdukRepository;

@Service
public class ProdukServiceImpl implements ProdukService{
	
	@Autowired
	private ProdukRepository produkRepository;

	@Override
	public Set<Produk> findAll	() {
		return new HashSet(produkRepository.findAll());
	}

	@Override
	public Produk save(Produk produk) {
		return produkRepository.save(produk);
	}

	@Override
	public Produk update(ObjectId _id, Produk produk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ObjectId _id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produk findOne(ObjectId _id) {
		return produkRepository.findBy_id(_id);
	}

}
