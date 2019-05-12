package com.deppatori.mysuperapp.restservice;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppatori.mysuperapp.exception.ExceptionName;
import com.deppatori.mysuperapp.exception.JerseyResourceNotFoundException;
import com.deppatori.mysuperapp.model.Customer;
import com.deppatori.mysuperapp.model.Produk;
import com.deppatori.mysuperapp.model.Purchase;
import com.deppatori.mysuperapp.model.PurchaseDetail;
import com.deppatori.mysuperapp.service.BaseService;
import com.deppatori.mysuperapp.service.CustomerService;
import com.deppatori.mysuperapp.service.ProdukService;
import com.deppatori.mysuperapp.service.PurchaseDetailService;
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
	
	@Autowired
	PurchaseDetailService purchaseDetailService;
	
	
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("/save-with-embedded")
	public Purchase saveWithEmbeddedData(Purchase purchase)  {
	
		
		
//		if(purchase.getProduks().size()==0) {
//			throw new BadRequestException();
//		}
//		
//		List<Produk> result = purchase.getProduks().stream().map(produk->{
//			ObjectId produk_id = produk.getId();
//			Produk findProduk = Optional.ofNullable(produkService.findOne(produk_id))
//					.orElseThrow(()->new BadRequestException());
//			return findProduk;
//			
//		}).collect(Collectors.toList());
//		purchase.setProduks(new HashSet(result));
		
		// check produk terdaftar di database atau gak
		List<PurchaseDetail> purchaseDetails = purchase.getPurchaseDetails();
		
		if(purchaseDetails.size()==0) {
			throw new JerseyResourceNotFoundException(new ExceptionName("No produk"));
		}
		
		final List<Object> temp = Arrays.asList(new BigDecimal(0),0);
		
		List<PurchaseDetail> hasil = purchaseDetails.stream().map(purchaseDetail->{
			ObjectId produk_id = purchaseDetail.getProduk().getId();
			Produk findProduk = Optional.ofNullable(produkService.findOne(produk_id))
					.orElseThrow(()->new JerseyResourceNotFoundException(new ExceptionName("Produk "+produk_id+" not found ")));
			BigDecimal total =  BigDecimal.valueOf(purchaseDetail.getJumlah()).multiply(findProduk.getHarga());
			purchaseDetail.setTotal(total);
			purchaseDetail.setHarga(findProduk.getHarga());
			purchaseDetail.setProduk(findProduk);
			
			temp.set(0,((BigDecimal) (temp.get(0))).add(total));
			
			
			
			return purchaseDetailService.save(purchaseDetail);
		}).collect(Collectors.toList());
		purchase.setPurchaseDetails(hasil);
		purchase.setTotalHarga((BigDecimal)temp.get(0));
		purchase.setJumlahProduk(hasil.size());
		
		
		
		// create customer first
		Customer newCustomer = customerService.save(purchase.getCustomer());
				
	    // set customer id after save to db
		purchase.getCustomer().set_id(newCustomer.getId());
		
		
		return purchaseService.save(purchase);
		
	
	}

	@Override
	public BaseService<Purchase> getService() {
		// TODO Auto-generated method stub
		return purchaseService;
	}
}
