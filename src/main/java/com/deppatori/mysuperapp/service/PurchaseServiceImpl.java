package com.deppatori.mysuperapp.service;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deppatori.mysuperapp.model.Customer;
import com.deppatori.mysuperapp.model.Purchase;
import com.deppatori.mysuperapp.repository.CustomerRepository;
import com.deppatori.mysuperapp.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public Set<Purchase> findAll() {
		// TODO Auto-generated method stub
		return new HashSet(purchaseRepository.findAll());
	}

	@Override
	public Purchase findOne(ObjectId _id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase save(Purchase t) {
		// TODO Auto-generated method stub
		return purchaseRepository.save(t);
	}

	@Override
	public Purchase update(ObjectId _id, Purchase t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ObjectId _id) {
		// TODO Auto-generated method stub
		
	}


}
