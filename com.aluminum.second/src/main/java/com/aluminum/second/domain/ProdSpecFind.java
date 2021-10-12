package com.aluminum.second.domain;

public class ProdSpecFind {
	private String prodid;
	private String specid;
	private float coefficient;
	private Integer price;
	public ProdSpecFind(String prodid, String specid, float coefficient, Integer price) {
		super();
		this.prodid = prodid;
		this.specid = specid;
		this.coefficient = coefficient;
		this.price = price;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public String getSpecid() {
		return specid;
	}
	public void setSpecid(String specid) {
		this.specid = specid;
	}
	public float getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
