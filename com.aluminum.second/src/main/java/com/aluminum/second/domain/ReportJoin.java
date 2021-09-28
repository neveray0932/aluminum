package com.aluminum.second.domain;

public class ReportJoin {
	
	private String reportid;
	private String customer;
	private Long total;
	private String workaddress;
	
	public ReportJoin() {
		
	}
	public ReportJoin(String reportid,String customer,Long total, String workaddress) {
		this.reportid = reportid;
		this.customer = customer;
		this.total = total;
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
	

}
