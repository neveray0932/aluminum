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


import lombok.Data;

@Entity
@Table(name="product")
@Data
public class ProductBean {
	@Id

	private String prodid;
	private String prodname;
	private Integer prodprice;
	


	

//	@JsonBackReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	@ManyToOne(fetch = FetchType.LAZY,cascade= {CascadeType.ALL})
	@JoinColumn(name="specidfk",referencedColumnName = "specid",insertable=false,updatable=true ) //name 是 table欄位名字 
	private SpecnameBean prodspecfk;                                  //referencedColumnName 是 來源pk

//	@JsonProperty("specidfk")
//	private void unpackNested( Integer specidfk ) {
//		this.specfk=new SpecnameBean();
//		specfk.setSpecid(specidfk);
//		
//	}
	
//	@JsonIgnore
	@OneToMany(mappedBy="prodfk",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<ReportDetailBean> reportproducts;
	

	

}
