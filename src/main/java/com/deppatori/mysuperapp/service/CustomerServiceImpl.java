package com.deppatori.mysuperapp.service;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deppatori.mysuperapp.model.Customer;
import com.deppatori.mysuperapp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Set<Customer> findAll() {
		// TODO Auto-generated method stub
		return new HashSet(customerRepository.findAll());
	}

	@Override
	public Customer findOne(ObjectId _id) {
		// TODO Auto-generated method stub
		return customerRepository.findBy_id(_id);
	}

	@Override
	public Customer save(Customer t) {
		// TODO Auto-generated method stub
		return customerRepository.save(t);
	}

	@Override
	public Customer update(ObjectId _id, Customer t) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findBy_id(_id);
		if(customer != null) {
			t.set_id(_id);
			return customerRepository.save(t);
		}
		
		return null;
		
		
	}

	@Override
	public void delete(ObjectId _id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(_id);
	}

}
