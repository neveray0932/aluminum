package com.aluminum.second.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReportDetailJoinAll2 {
	private String reportid;
	private Integer customerid;
	private String customer;
	private String prodid;
	private Integer reportunitprice;
	private Integer prodcount;
	private float coefficient;
	@JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
	private java.util.Date reportdate;
	private Integer taxnumber;
	private String contact;
	private String tel;
	private String reportmark;
	private String workaddress;
	public ReportDetailJoinAll2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportDetailJoinAll2(String reportid, Integer customerid, String customer, String prodid,
			Integer reportunitprice, Integer prodcount, float coefficient, Date reportdate, Integer taxnumber,
			String contact, String tel, String reportmark, String workaddress) {
		super();
		this.reportid = reportid;
		this.customerid = customerid;
		this.customer = customer;
		this.prodid = prodid;
		this.reportunitprice = reportunitprice;
		this.prodcount = prodcount;
		this.coefficient = coefficient;
		this.reportdate = reportdate;
		this.taxnumber = taxnumber;
		this.contact = contact;
		this.tel = tel;
		this.reportmark = reportmark;
		this.workaddress = workaddress;
	}
	public String getReportid() {
		return reportid;
	}
	public void setReportid(String reportid) {
		this.reportid = reportid;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public Integer getReportunitprice() {
		return reportunitprice;
	}
	public void setReportunitprice(Integer reportunitprice) {
		this.reportunitprice = reportunitprice;
	}
	public Integer getProdcount() {
		return prodcount;
	}
	public void setProdcount(Integer prodcount) {
		this.prodcount = prodcount;
	}
	public float getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}
	public java.util.Date getReportdate() {
		return reportdate;
	}
	public void setReportdate(java.util.Date reportdate) {
		this.reportdate = reportdate;
	}
	public Integer getTaxnumber() {
		return taxnumber;
	}
	public void setTaxnumber(Integer taxnumber) {
		this.taxnumber = taxnumber;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getReportmark() {
		return reportmark;
	}
	public void setReportmark(String reportmark) {
		this.reportmark = reportmark;
	}
	public String getWorkaddress() {
		return workaddress;
	}
	public void setWorkaddress(String workaddress) {
		this.workaddress = workaddress;
	}
	
	

	
	


	
	
	
}
