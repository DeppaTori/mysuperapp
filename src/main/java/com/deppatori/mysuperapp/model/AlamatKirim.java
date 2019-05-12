package com.deppatori.mysuperapp.model;

public class AlamatKirim extends BaseModel{
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private Integer city;
	private Integer province;
	private Integer zipCode;
	private Integer country;
	
	public AlamatKirim() {
		super();
	}
	
	
	
	
	public AlamatKirim(String firstName, String lastName, String address1, String address2, Integer city,
			Integer province, Integer zipCode, Integer country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
		this.country = country;
	}




	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getCountry() {
		return country;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
	
	
	
}
