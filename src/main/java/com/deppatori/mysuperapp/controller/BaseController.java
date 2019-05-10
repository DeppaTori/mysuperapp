package com.deppatori.mysuperapp.controller;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.deppatori.mysuperapp.model.BaseModel;
import com.deppatori.mysuperapp.service.BaseService;

public class BaseController<T extends BaseModel>{
	
	@Autowired
	private BaseService<T> service;
	
	@GetMapping
	public Set<T> getAll() {
		return service.findAll();
	}
	
	@PostMapping
	public T save(@RequestBody T t) {
		return service.save(t);
	}
	
	@GetMapping("/{id}")
	public T getOne(@PathVariable ObjectId id) {
		return service.findOne(id);
	}

}
