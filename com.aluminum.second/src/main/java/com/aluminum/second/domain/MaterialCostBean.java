package com.aluminum.second.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@IdClass(MaterialCostBean.ConfigId.class)
@Entity
@Table(name="material_cost")
@Data
public class MaterialCostBean implements Serializable {
	private static final long serialVersionUID = 1L;
//	private static Integer a = 1;
	
	@Id
	@Column(name="materialid")
	String materialid;
	
	@Id
	@Column(name="specid")
	String specid;
	
//	@Column(name="materialname")
//	String materialname;
	
	@Column(name="cost")
	Integer cost;
	
	@Column(name="dosage")
	float dosage;
	@Column(name="total")
	Integer total;
	
	@Column(name="doorjudge")
	String doorjudge;
	
	
	@JsonIgnore

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name="materialid",
			referencedColumnName = "materialid",
			insertable=false,updatable=false
	)
	
	private MaterialBean materialfk;
	
//	@JsonIgnore
	@JsonBackReference("spec-materialcost")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name="specid",
			referencedColumnName = "specid",
			insertable=false,updatable=false
	)
	
	private SpecnameBean specfk;
	
	
//	@JsonIgnore
//	@JsonBackReference("door-materialcost")
//	@ManyToOne(cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
//	@JoinColumn(
//			name="doorinfofk",
//			referencedColumnName = "doorinfoid",
//			insertable=false,updatable=false
//	)
//	
//	private DoorInfoBean doorfk;
	

	
	// 靜態內部類
	public static class ConfigId implements Serializable{
		 // 靜態內部類只能訪問外部類的靜態成員
		
		private static final long serialVersionUID = 1L;
		private String materialid;
		private String specid;
		public String getMaterialid() {
			return materialid ;
		}
		public void setMaterialid(String materialid) {
			this.materialid = materialid;
		}
		public String getSpecid() {
			return specid;
		}
		public void setSpecid(String specid) {
			this.specid = specid;
		}
		
	}



	@Override
	public String toString() {
		return "MaterialCostBean [materialid=" + materialid + ", specid=" + specid + ", cost=" + cost + ", dosage="
				+ dosage + ", total=" + total + "]";
	}

	
}
