package com.deppatori.mysuperapp.controller;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deppatori.mysuperapp.model.Produk;
import com.deppatori.mysuperapp.service.ProdukService;

@RestController
@RequestMapping("/api/v1/produk")
public class ProdukController {
	
	@Autowired
	private ProdukService produkService;
	
	@GetMapping
	public Set<Produk> getAll(){
		return produkService.findAll();
	}
	
	@PostMapping
	public Produk save(@RequestBody Produk produk) {
		return produkService.save(produk);
	}
	
	@GetMapping("/{id}")
	public Produk getOne(@PathVariable ObjectId id) {
		return produkService.findOne(id);
	}
}
