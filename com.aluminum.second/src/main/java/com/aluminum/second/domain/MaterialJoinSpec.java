package com.aluminum.second.domain;

public class MaterialJoinSpec {
	private String materialid;
	
	private String specname;
	private Integer unitprice;
	private float dosage;
	private Integer total;
	
	public MaterialJoinSpec(String materialid, String specname, Integer unitprice, float dosage, Integer total) {
		super();
		this.materialid = materialid;
		this.specname = specname;
		this.unitprice = unitprice;
		this.dosage = dosage;
		this.total = total;
	}

	public String getMaterialid() {
		return materialid;
	}

	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}

	public String getSpecname() {
		return specname;
	}

	public void setSpecname(String specname) {
		this.specname = specname;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public float getDosage() {
		return dosage;
	}

	public void setDosage(float dosage) {
		this.dosage = dosage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	


}
