package com.deppatori.mysuperapp.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Purchase extends BaseModel{
	
	private String purchaseNo;
	
	private Date purchaseDate;
	
	private Customer customer;
	
	private List<PurchaseDetail> purchaseDetails;
	
	private BigDecimal totalHarga;
	private int jumlahProduk;
	
	
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



	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}



	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}



	public BigDecimal getTotalHarga() {
		return totalHarga;
	}



	public void setTotalHarga(BigDecimal totalHarga) {
		this.totalHarga = totalHarga;
	}



	public int getJumlahProduk() {
		return jumlahProduk;
	}



	public void setJumlahProduk(int jumlahProduk) {
		this.jumlahProduk = jumlahProduk;
	}



	public String getPurchaseNo() {
		return purchaseNo;
	}



	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	
	


	
	


	
	
	
	
	
	
	
}
