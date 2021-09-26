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
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name="report")
@Data
public class WebReportBean {
	@Id
	private String reportid;
	@JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
	private java.util.Date reportdate;
	private String customer;
	private String contact;
	private String tel;
	private String workaddress;
	private String reportmark;
	
	@JsonBackReference(value="cust-report")
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity = CustomerBean.class,fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="customeridfk",referencedColumnName = "customerid")
	private CustomerBean customerfk;
	
//	@JsonProperty("customeridfk")
//	private void unpackNested(Integer customeridfk) {
//		this.customerfk=new CustomerBean();
//		customerfk.setCustomerid(customeridfk);
//	}

	@OneToMany(mappedBy="reportfk",cascade= {CascadeType.ALL},fetch = FetchType.LAZY)
	private List<ReportDetailBean> reportDetails;

	@Override
	public String toString() {
		return "WebReportBean [reportid=" + reportid + ", reportdate=" + reportdate + ", customer=" + customer
				+ ", contact=" + contact + ", tel=" + tel + ", workaddress=" + workaddress + ", reportmark="
				+ reportmark + "]";
	}


}
