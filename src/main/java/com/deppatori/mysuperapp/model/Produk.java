package com.deppatori.mysuperapp.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Produk extends BaseModel{

	private String nama;
	private String deskripsi;
	private BigDecimal harga;
	private String gambar;
	
	public Produk() {
		
	}

	public Produk(ObjectId _id, String nama, String deskripsi, BigDecimal harga, String gambar) {
		super();
		this.set_id(_id);
		this.nama = nama;
		this.deskripsi = deskripsi;
		this.harga = harga;
		this.gambar = gambar;
	}


	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public BigDecimal getHarga() {
		return harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}

	public String getGambar() {
		return gambar;
	}

	public void setGambar(String gambar) {
		this.gambar = gambar;
	}
	
	
}
