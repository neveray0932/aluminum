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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class ProductBean {
	@Id

	private String prodid;
	private String prodname;
	private Integer prodnum;
	private Integer prodprice;
	


	

//	@JsonBackReference("spec-product")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	@ManyToOne(fetch = FetchType.LAZY,cascade= {CascadeType.ALL})
	@JoinColumn(name="specidfk",referencedColumnName = "specid",insertable=true,updatable=true ) //name 是 table欄位名字 
	private SpecnameBean prodspecfk;                                  //referencedColumnName 是 來源pk

//	@JsonProperty("specidfk")
//	private void unpackNested( String specidfk ) {
//		this.prodspecfk=new SpecnameBean();
//		prodspecfk.setSpecid(specidfk);;
//		
//	}
	
//	@JsonIgnore
	@OneToMany(mappedBy="prodfk",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<ReportDetailBean> reportproducts;

	@Override
	public String toString() {
		return "ProductBean [prodid=" + prodid + ", prodname=" + prodname + ", prodnum=" + prodnum + ", prodprice="
				+ prodprice + "]";
	}
	

	

}
