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


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class ProductBean {
	@Id

	private String prodid;
//	private String prodname;
//	private Integer prodnum;
//	private float coefficient;
	private String prodmark;
//	private Integer prodprice;
	


	

                                //referencedColumnName 是 來源pk

//	@JsonProperty("specidfk")
//	private void unpackNested( String specidfk ) {
//		this.prodspecfk=new SpecnameBean();
//		prodspecfk.setSpecid(specidfk);;
//		
//	}
	
//	@JsonIgnore
	@OneToMany(mappedBy="prodfk",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<ReportDetailBean> reportproducts;
	
	@JsonManagedReference("prod-prodspec")
	@OneToMany(mappedBy="products",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<ProdSpecBean> prodspecs;

	@Override
	public String toString() {
		return "ProductBean [prodid=" + prodid + ", prodmark=" + prodmark + ", reportproducts=" + reportproducts
				+ ", prodspecs=" + prodspecs + "]";
	}


	
	

//	@Override
//	public String toString() {
//		return "ProductBean [prodid=" + prodid + ", prodname=" + prodname + ", prodnum=" + prodnum + ", coefficient="
//				+ coefficient + ", prodmark=" + prodmark + ", prodprice=" + prodprice + "]";
//	}


	
	

	

}
