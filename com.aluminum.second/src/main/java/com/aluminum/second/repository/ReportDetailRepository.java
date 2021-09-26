package com.aluminum.second.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.aluminum.second.domain.ReportDetailBean;

import com.aluminum.second.domain.ReportDetailBean.ConfigId;
import com.aluminum.second.domain.ReportJoin;

public interface ReportDetailRepository extends JpaRepository<ReportDetailBean, ConfigId> {

	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.ReportJoin(rdb.reportid, rdb.reportfk.customer, SUM(rdb.reportprice), rdb.reportfk.workaddress) FROM ReportDetailBean rdb"
			+ " JOIN rdb.reportfk "
			+"JOIN rdb.prodfk "
			+ "GROUP BY rdb.reportid, rdb.reportfk.customer,rdb.reportfk.workaddress "
			)
	List<ReportJoin> reportJoin();
	
	
	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.ReportDetailJoinAll(rdb.reportid, rdb.reportfk.customer, rdb.prodfk.prodid, rdb.prodfk.prodprice, rdb.reportcount, rdb.reportfk.reportdate, rdb.reportfk.customerfk.taxnumber, rdb.reportfk.customerfk.contact, rdb.reportfk.customerfk.tel, rdb.reportfk.reportmark, rdb.reportfk.workaddress) FROM ReportDetailBean rdb"
			+ " JOIN rdb.reportfk "
			+"JOIN rdb.prodfk "
			+"JOIN rdb.reportfk.customerfk"
			+ " WHERE rdb.reportid = ?1"
			
			)
	List<com.aluminum.second.domain.ReportDetailJoinAll> ReportDetailJoinAll(String reportid);
	
//	@Transactional
//	@Query("INSERT INTO new com.aluminum.second.domain.ReportDetailJoinAll(reportid, customer, prodname, prodprice, reportcount, reportdate, taxnumber, contact, tel, reportmark, workaddress)"
//			
//			+ "VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11) "
//			)
//	int insertreportJoin(String reportid, String customer, String prodname, Integer prodprice,
//			Integer reportcount, Date reportdate, Integer taxnumber, String contact, String tel, String reportmark,
//			String workaddress);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
