package com.deppatori.mysuperapp.model;

import java.util.Date;
import java.util.Set;

public class Purchase extends BaseModel{
	
	
	private Date purchaseDate;
	
	private Customer customer;
	
	private Set<Produk> produks;
	
	public Purchase() {
		
	}

	
	
	public Date getPurchaseDate() {
		return purchaseDate;
	}



	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Set<Produk> getProduks() {
		return produks;
	}



	public void setProduks(Set<Produk> produks) {
		this.produks = produks;
	}
	
	
	
	
	
}
