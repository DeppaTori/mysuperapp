package com.deppatori.mysuperapp.model;

import java.math.BigDecimal;

public class PurchaseDetail extends BaseModel{
	private int jumlah;
	private Produk produk;
	private BigDecimal harga;
	private BigDecimal total;
	
	public PurchaseDetail() {
		super();
	}
	
	
	
	public PurchaseDetail(int jumlah, Produk produk, BigDecimal harga, BigDecimal total) {
		super();
		this.jumlah = jumlah;
		this.produk = produk;
		this.harga = harga;
		this.total = total;
	}



	public int getJumlah() {
		return jumlah;
	}
	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	public Produk getProduk() {
		return produk;
	}
	public void setProduk(Produk produk) {
		this.produk = produk;
	}
	public BigDecimal getHarga() {
		return harga;
	}
	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
