package com.aluminum.second.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name="material")
@Data
public class MaterialBean {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String materialid;

	String category;
	float coefficient;
	Integer unitprice;
	String units;
	Integer cost;
	String memo;
	
//	@JsonIgnore
	@OneToMany(mappedBy="materialfk",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<MaterialCostBean> materialcosts;

	@Override
	public String toString() {
		return "MaterialBean [materialid=" + materialid + ", category=" + category + ", coefficient=" + coefficient
				+ ", unitprice=" + unitprice + ", units=" + units + ", cost=" + cost + ", memo=" + memo + "]";
	}
	
}
