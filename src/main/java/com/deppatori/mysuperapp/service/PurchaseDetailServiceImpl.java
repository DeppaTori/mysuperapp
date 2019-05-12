package com.deppatori.mysuperapp.service;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deppatori.mysuperapp.model.PurchaseDetail;
import com.deppatori.mysuperapp.repository.PurchaseDetailRepository;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService{
	
	@Autowired
	PurchaseDetailRepository purchaseDetailRepository;

	@Override
	public Set<PurchaseDetail> findAll() {
		// TODO Auto-generated method stub
		return new HashSet<>(purchaseDetailRepository.findAll());
	}

	@Override
	public PurchaseDetail findOne(ObjectId _id) {
		// TODO Auto-generated method stub
		return purchaseDetailRepository.findBy_id(_id);
	}

	@Override
	public PurchaseDetail save(PurchaseDetail t) {
		// TODO Auto-generated method stub
		return purchaseDetailRepository.save(t);
	}

	@Override
	public PurchaseDetail update(ObjectId _id, PurchaseDetail t) {
		// TODO Auto-generated method stub
		PurchaseDetail purchaseDetail = findOne(_id);
		if(purchaseDetail==null) {
			return null;
		}
		t.set_id(purchaseDetail.getId());
		return purchaseDetailRepository.save(t);
	}

	@Override
	public void delete(ObjectId _id) {
		purchaseDetailRepository.deleteById(_id.toHexString());
		
	}

}
