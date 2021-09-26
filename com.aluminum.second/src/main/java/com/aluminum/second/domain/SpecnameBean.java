package com.aluminum.second.domain;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="specname")
@Data
public class SpecnameBean {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String specid;
//	private String specname;
//	private String prodname;


	@JsonManagedReference("spec-materialcost")
	@OneToMany(mappedBy="specfk",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<MaterialCostBean> materialcosts;

	@JsonIgnore
//	@JsonManagedReference
	@OneToMany(mappedBy="prodspecfk",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<ProductBean> products;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity = DoorInfoBean.class,fetch = FetchType.LAZY)
	@JoinColumn(name="doorinfofk",referencedColumnName = "doorinfoid")
	private DoorInfoBean doorinfofks;     //嚴禁重複命名

	@Override
	public String toString() {
		return "SpecnameBean [specid=" + specid + "]";
	}

	
	
	
}
