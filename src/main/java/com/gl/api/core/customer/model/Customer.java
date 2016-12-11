package com.gl.api.core.customer.model;

public class Customer {
	private String name, zip, city;
	private boolean isFirstPurchase;
	public Customer(String name, String zip,
			String city, boolean isFirstPurchase) {
		super();
		this.name = name;
		this.zip = zip;
		this.city = city;
		this.isFirstPurchase = isFirstPurchase;
	}
	
	public Customer(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean getIsFirstPurchase() {
		return isFirstPurchase;
	}
	public void setIsFirstPurchase(boolean isFirstPurchase) {
		this.isFirstPurchase = isFirstPurchase;
	}
}