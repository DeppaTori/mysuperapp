package com.deppatori.mysuperapp.controller;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deppatori.mysuperapp.model.Buku;
import com.deppatori.mysuperapp.repository.BukuRepository;



@RestController
@RequestMapping("/buku")
public class BukuController {
	
	@Autowired
	private BukuRepository bukuRepository;
	
	@GetMapping
	public List<Buku> getAllBuku(){
		return bukuRepository.findAll();
	}
	
	@GetMapping("/test")
	public List<Buku> getAllBuku2(){
		return bukuRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Buku getBukuById(@PathVariable ObjectId id) {
		return bukuRepository.findBy_id(id);
	}
	
	@PutMapping("/{id}")
	public Buku updateBuku(@PathVariable ObjectId id,@RequestBody Buku buku) {
		buku.set_id(id);
		return bukuRepository.save(buku);
	}
	
	@PostMapping
	public Buku insertBuku(@RequestBody Buku buku) {
		return bukuRepository.save(buku);
		
	}
	
	/*
	 	@PostMapping(produces = "application/json", consumes="application/json")
	public ResponseEntity<Void> insertBuku(@RequestBody Buku buku) {
			bukuRepository.save(buku);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	 */
	
	@DeleteMapping("/{id}")
	public void deleteBuku(@PathVariable ObjectId id) {
		Buku foundBuku = bukuRepository.findBy_id(id);
		if(foundBuku != null) {
			bukuRepository.delete(foundBuku);
		}
	}
}
