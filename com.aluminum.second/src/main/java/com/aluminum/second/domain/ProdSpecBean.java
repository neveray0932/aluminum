package com.aluminum.second.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.Data;



@IdClass(ProdSpecBean.ConfigId.class)
@Entity
@Table(name="prod_spec")
@Data
//複合主鍵需要實作序列化
public class ProdSpecBean {
	
	@Id
	@Column(name="prodid")
	private String prodid;
	
	@Id
	@Column(name="specid")
	private String specid;
	
	@Column(name="coefficient")
	private float coefficient;
	
	@Column(name="price")
	private Integer price;
	
	
//	@JsonIgnore
	@JsonBackReference("prod-prodspec")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name="prodid",//原table上的column名
			referencedColumnName = "prodid",//來源table的column名
			insertable=false,updatable=false
	)
	private ProductBean products;
	
//	@JsonIgnore
	@JsonBackReference("spec-prodspec")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			name="specid",//原table上的column名
			referencedColumnName = "specid",//來源table的column名
			insertable=false,updatable=false
	)
	private SpecnameBean specs;
	
	
	// 靜態內部類
		public static class ConfigId implements Serializable{
			 // 靜態內部類只能訪問外部類的靜態成員
			
			private static final long serialVersionUID = 1L;
			private String prodid;
			private String specid;
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
			
		}


		@Override
		public String toString() {
			return "ProdSpecBean [prodid=" + prodid + ", specid=" + specid + ", coefficient=" + coefficient + ", price="
					+ price + "]";
		}



	

}
