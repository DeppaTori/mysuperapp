package com.deppatori.mysuperapp.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Buku {
	
	@Id
	private ObjectId _id;
	
	private String judul;
	private String deskripsi;
	private String pengarang;
	private BigDecimal harga;
	
	public Buku() {
		
	}
	
	public Buku(ObjectId _id,String judul, String deskripsi, String pengarang, BigDecimal harga) {
		this._id = _id;
		this.judul = judul;
		this.deskripsi = deskripsi;
		this.pengarang = pengarang;
		this.harga = harga;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getPengarang() {
		return pengarang;
	}

	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}

	public BigDecimal getHarga() {
		return harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}
	
	
}
