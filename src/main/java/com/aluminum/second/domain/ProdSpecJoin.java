package com.aluminum.second.domain;

public class ProdSpecJoin {
	private String prodid;
	private String specid;
	private float coefficient;
	private Integer price;
	private String prodmark;
	private String doorinfo;
	public ProdSpecJoin(String prodid, String specid, float coefficient, Integer price, String prodmark,
			String doorinfo) {
		super();
		this.prodid = prodid;
		this.specid = specid;
		this.coefficient = coefficient;
		this.price = price;
		this.prodmark = prodmark;
		this.doorinfo = doorinfo;
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
	public String getProdmark() {
		return prodmark;
	}
	public void setProdmark(String prodmark) {
		this.prodmark = prodmark;
	}
	public String getDoorinfo() {
		return doorinfo;
	}
	public void setDoorinfo(String doorinfo) {
		this.doorinfo = doorinfo;
	}
	
	
	
	

}
