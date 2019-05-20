package com.deppatori.mysuperapp.restservice;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppatori.mysuperapp.exception.ExceptionName;
import com.deppatori.mysuperapp.exception.JerseyResourceNotFoundException;
import com.deppatori.mysuperapp.mail.SendPurchaseMail;
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
	
	@Autowired
	SendPurchaseMail sendPurchaseMail;
	
	
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("/save-with-embedded")
	public Purchase saveWithEmbeddedData(Purchase purchase) throws AddressException,MessagingException,IOException{
	
		
		
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
		purchase.setPurchaseDate(new Date());
		purchase.setPurchaseDetails(hasil);
		purchase.setTotalHarga((BigDecimal)temp.get(0));
		purchase.setJumlahProduk(hasil.size());
		
	
		
		purchase.setPurchaseNo(Long.toString(new Date().getTime()));
		
		
		
		// create customer first
		Customer newCustomer = customerService.save(purchase.getCustomer());
				
	    // set customer id after save to db
		purchase.getCustomer().set_id(newCustomer.getId());
		
		
		Purchase newPurchase = purchaseService.save(purchase);
		
		/*SEND EMAIL*/
		sendPurchaseMail.send(newPurchase);
		
		return newPurchase;
		
	
	}
	
//	@GET
//	@Path("/mail")
//	public void sentMail() throws AddressException,MessagingException,IOException{
//		sendPurchaseMail.send();
//		
//	}
	
//	@Produces(MediaType.TEXT_HTML)
//	@GET
//	@Path("/html")
//	public String purchaseHtml() {
//		
//		Purchase purchase = purchaseService.findOne(new ObjectId("5cd7af9677e8f2278454d68f"));
//		return sendPurchaseMail.getMailContent(purchase);
//	}

	@Override
	public BaseService<Purchase> getService() {
		// TODO Auto-generated method stub
		return purchaseService;
	}
}
