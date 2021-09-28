package com.aluminum.second.domain;




import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="customer")
@Data
public class CustomerBean  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerid;
	private String customer;
	
	private String title;
	private String address;
	private String tel;
	private String fax;
	private String contact;
	private String cellphone;
	private Integer taxnumber;
	

	@JsonManagedReference(value="cust-report")
//	@JsonIgnore
	@OneToMany(mappedBy="customerfk",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<WebReportBean> webReports;


	@Override
	public String toString() {
		return "CustomerBean [customerid=" + customerid + ", customer=" + customer + ", title=" + title + ", address="
				+ address + ", tel=" + tel + ", fax=" + fax + ", contact=" + contact + ", cellphone=" + cellphone
				+ ", taxnumber=" + taxnumber + "]";
	}
	
	

}
