package com.aluminum.second.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReportJoin {
	
	private String reportid;
	private Integer customerid;
	private String customer;
	private Long total;
	private String workaddress;
	@JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date reportdate;
	private boolean invalid;
	public ReportJoin(String reportid, Integer customerid, String customer, Long total, String workaddress,
			Date reportdate, boolean invalid) {
		super();
		this.reportid = reportid;
		this.customerid = customerid;
		this.customer = customer;
		this.total = total;
		this.workaddress = workaddress;
		this.reportdate = reportdate;
		this.invalid = invalid;
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
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public String getWorkaddress() {
		return workaddress;
	}
	public void setWorkaddress(String workaddress) {
		this.workaddress = workaddress;
	}
	public Date getReportdate() {
		return reportdate;
	}
	public void setReportdate(Date reportdate) {
		this.reportdate = reportdate;
	}
	public boolean isInvalid() {
		return invalid;
	}
	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}
	
	
	
	


}
