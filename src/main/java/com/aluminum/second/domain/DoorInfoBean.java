package com.aluminum.second.domain;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

@Entity
@Table(name="doorinfo")
@Data
public class DoorInfoBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doorinfoid;
	private String doorinfo;
	
	@JsonIgnore
	@OneToMany(targetEntity = SpecnameBean.class,fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinColumn(name="doorinfofk",referencedColumnName = "doorinfoid")
	private Set<SpecnameBean> specnames = new HashSet<SpecnameBean>(0);
	
//	@JsonIgnore
//	@JsonManagedReference("door-materialcost")
//	@OneToMany(mappedBy = "doorfk",fetch = FetchType.LAZY,cascade= {CascadeType.ALL})
//	private List<MaterialCostBean> materialcosts;
}
