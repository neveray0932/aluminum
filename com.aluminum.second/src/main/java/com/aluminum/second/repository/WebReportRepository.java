package com.aluminum.second.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import com.aluminum.second.domain.WebReportBean;
import com.aluminum.second.domain.WebReportCount;

public interface WebReportRepository extends JpaRepository<WebReportBean, String> {

	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.WebReportCount(COUNT(wrb.reportid)) FROM WebReportBean wrb"
			+ " WHERE wrb.reportdate=CONVERT (date, GETDATE())"
			
			)
	List<WebReportCount> webreportCount();
}
