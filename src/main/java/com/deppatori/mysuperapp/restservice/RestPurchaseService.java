package com.deppatori.mysuperapp.restservice;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.deppatori.mysuperapp.exception.ResourceNotFoundException;
import com.deppatori.mysuperapp.model.Customer;
import com.deppatori.mysuperapp.model.Produk;
import com.deppatori.mysuperapp.model.Purchase;
import com.deppatori.mysuperapp.service.BaseService;
import com.deppatori.mysuperapp.service.CustomerService;
import com.deppatori.mysuperapp.service.ProdukService;
import com.deppatori.mysuperapp.service.PurchaseService;

@Service
@Path("/api/v2/purchases")
public class RestPurchaseService extends RestBaseService<Purchase>{
	
	@Autowired
	PurchaseService purchaseService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProdukService produkService;
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("/save-with-embedded")
	public Purchase saveWithEmbeddedData(Purchase purchase) {
		// find customer
		ObjectId customer_id = purchase.getCustomer().getId();
		Customer customer = Optional.ofNullable(customerService.findOne(customer_id))
				.orElseThrow(()->new NotFoundException());
		purchase.setCustomer(customer);
		
		if(purchase.getProduks().size()==0) {
			throw new BadRequestException();
		}
		
		List<Produk> result = purchase.getProduks().stream().map(produk->{
			ObjectId produk_id = produk.getId();
			Produk findProduk = Optional.ofNullable(produkService.findOne(produk_id))
					.orElseThrow(()->new NotFoundException());
			return findProduk;
			
		}).collect(Collectors.toList());
		purchase.setProduks(new HashSet(result));
		
		
		return purchaseService.save(purchase);
		
	
	}

	@Override
	public BaseService<Purchase> getService() {
		// TODO Auto-generated method stub
		return purchaseService;
	}
}
