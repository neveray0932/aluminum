package com.aluminum.second.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@IdClass(ReportDetailBean.ConfigId.class)
@Entity
@Table(name="report_detail")
@Data
public class ReportDetailBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reportid")
	String reportid;
	
	@Id
	@Column(name="prodid")
	String prodid;
	
	@Column(name="prodprice")
	Integer prodprice;
	
	@Column(name="reportcount")
	Integer reportcount;
	
	@Column(name="reportunitprice")
	Integer reportunitprice;
	
	@Column(name="reportprice")
	Integer reportprice;
	
	@JsonIgnore
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(
			name="reportid", //原表上的colum名
			referencedColumnName = "reportid", //來源名
			insertable=false,updatable=false
			)
	private WebReportBean reportfk;
	
	@JsonIgnore
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(
			name="prodid",
			referencedColumnName = "prodid",
			insertable=false,updatable=false
			)
	private ProductBean prodfk;

	@Override
	public String toString() {
		return "ReportDetailBean [reportid=" + reportid + ", prodid=" + prodid + ", reportcount=" + reportcount
				+ ", reportunitprice=" + reportunitprice + ", reportprice=" + reportprice + ", reportfk=" + reportfk
				+ ", prodfk=" + prodfk + "]";
	}
	public static class ConfigId implements Serializable{
		private static final long serialVersionUID = 1L;
		private String reportid;
		private String prodid;
		public String getReportid() {
			return reportid;
		}
		public void setReportid(String reportid ) {
			this.reportid=reportid;
		}
		public String getProdid() {
			return prodid;
		}
		public void setProdid(String prodid) {
			this.prodid=prodid;
		}
	}
}
