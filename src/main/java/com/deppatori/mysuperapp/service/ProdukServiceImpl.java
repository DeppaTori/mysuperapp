package com.deppatori.mysuperapp.service;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deppatori.mysuperapp.model.BaseModel;
import com.deppatori.mysuperapp.model.Produk;
import com.deppatori.mysuperapp.repository.BukuRepository;
import com.deppatori.mysuperapp.repository.ProdukRepository;

@Service
public class ProdukServiceImpl implements ProdukService{
	
	@Autowired
	private ProdukRepository produkRepository;

	@Override
	public Set<Produk> findAll() {
		// TODO Auto-generated method stub
		return new HashSet(produkRepository.findAll());
	}

	@Override
	public Produk findOne(ObjectId _id) {
		// TODO Auto-generated method stub
		return produkRepository.findBy_id(_id);
	}

	@Override
	public Produk save(Produk t) {
		// TODO Auto-generated method stub
		return produkRepository.save(t);
	}

	@Override
	public Produk update(ObjectId _id, Produk t) {
		// TODO Auto-generated method stub
		Produk find = produkRepository.findBy_id(_id);
		if(find==null) {
			return null;
		}
		t.set_id(_id);
		return produkRepository.save(t);
	}

	@Override
	public void delete(ObjectId _id) {
		produkRepository.deleteById(_id.toHexString());
		
	}

	

	

}
