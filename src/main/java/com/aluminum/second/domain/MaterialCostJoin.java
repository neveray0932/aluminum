package com.aluminum.second.domain;

public class MaterialCostJoin {
	private String specid;
	private String materialid;
	private float dosage;
	private Integer cost;
	private float total;

	public MaterialCostJoin(String specid, String materialid, float dosage, Integer cost, float total) {
		super();
		this.specid = specid;
		this.materialid = materialid;
		this.dosage = dosage;
		this.cost = cost;
		this.total = total;
	}

	public String getSpecid() {
		return specid;
	}

	public void setSpecid(String specid) {
		this.specid = specid;
	}

	public String getMaterialid() {
		return materialid;
	}

	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}

	public float getDosage() {
		return dosage;
	}

	public void setDosage(float dosage) {
		this.dosage = dosage;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
