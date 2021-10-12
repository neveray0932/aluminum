package com.aluminum.second.domain;

public class ReportDetailFind {
	private String reportid;
	private String prodid;
	public ReportDetailFind(String reportid, String prodid) {
		super();
		this.reportid = reportid;
		this.prodid = prodid;
	}
	public String getReportid() {
		return reportid;
	}
	public void setReportid(String reportid) {
		this.reportid = reportid;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	

}
