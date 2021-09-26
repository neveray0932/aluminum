package com.aluminum.second.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReportDetailJoinAll {
	private String reportid;
	private String customer;
	private String prodid;
	private Integer prodprice;
	private Integer reportcount;

	private java.util.Date reportdate;
	private Integer taxnumber;
	private String contact;
	private String tel;
	private String reportmark;
	private String workaddress;
	public ReportDetailJoinAll() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ReportDetailJoinAll(String reportid, String customer, String prodid, Integer prodprice,
			Integer reportcount, Date reportdate, Integer taxnumber, String contact, String tel, String reportmark,
			String workaddress) {
		super();
		this.reportid = reportid;
		this.customer = customer;
		this.prodid = prodid;
		this.prodprice = prodprice;
		this.reportcount = reportcount;
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
	public Integer getProdprice() {
		return prodprice;
	}
	public void setProdprice(Integer prodprice) {
		this.prodprice = prodprice;
	}
	public Integer getReportcount() {
		return reportcount;
	}
	public void setReportcount(Integer reportcount) {
		this.reportcount = reportcount;
	}
	@JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
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
