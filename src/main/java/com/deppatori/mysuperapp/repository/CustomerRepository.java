package com.deppatori.mysuperapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deppatori.mysuperapp.model.Customer;

public interface CustomerRepository extends BaseRepository<Customer, String>{

}
