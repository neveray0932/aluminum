package com.aluminum.second.domain;

public class SpecPriceBean {
	private Long totalprice;
	private String specid;
	
	
	public SpecPriceBean (Long totalprice,String specid) {
		this.specid = specid;
		this.totalprice = totalprice;
		
	}


	public Long getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(Long totalprice) {
		this.totalprice = totalprice;
	}


	public String getSpecid() {
		return specid;
	}


	public void setSpecid(String specid) {
		this.specid = specid;
	}

	

	

}
