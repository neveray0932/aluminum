package com.aluminum.second.domain;

public class ProdSpecClc {
	private String prodid;
	private float price;
	public ProdSpecClc(String prodid, float price) {
		super();
		this.prodid = prodid;
		this.price = price;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	};

}
