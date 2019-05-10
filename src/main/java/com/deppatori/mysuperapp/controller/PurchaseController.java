package com.deppatori.mysuperapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deppatori.mysuperapp.exception.BadRequestException;
import com.deppatori.mysuperapp.exception.ResourceNotFoundException;
import com.deppatori.mysuperapp.model.Customer;
import com.deppatori.mysuperapp.model.Produk;
import com.deppatori.mysuperapp.model.Purchase;
import com.deppatori.mysuperapp.service.CustomerService;
import com.deppatori.mysuperapp.service.ProdukService;
import com.deppatori.mysuperapp.service.PurchaseService;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController extends BaseController<Purchase>{
	
	@Autowired
	PurchaseService purchaseService;
	
	@Autowired
	ProdukService produkService;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/save-with-embedded")
	public Purchase saveWithEmbeddedData(@RequestBody Purchase purchase) {
		// find customer
		ObjectId customer_id = purchase.getCustomer().getId();
		Customer customer = Optional.ofNullable(customerService.findOne(customer_id))
				.orElseThrow(()->new ResourceNotFoundException("Customer",customer_id));
		purchase.setCustomer(customer);
		
		if(purchase.getProduks().size()==0) {
			throw new BadRequestException("No produk");
		}
		
		List<Produk> result = purchase.getProduks().stream().map(produk->{
			ObjectId produk_id = produk.getId();
			Produk findProduk = Optional.ofNullable(produkService.findOne(produk_id))
					.orElseThrow(()->new ResourceNotFoundException("Produk",produk_id));
			return findProduk;
			
		}).collect(Collectors.toList());
		purchase.setProduks(new HashSet(result));
		
		
		return purchaseService.save(purchase);
		
		// find product
	
	//	Product product = produkService.findOne(purchase.getProduks());
		
		//Purchase purchase = new Purchase();
		//return purchase;
	}
}
