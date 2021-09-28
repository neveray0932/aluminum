package com.aluminum.second.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluminum.second.domain.WebReportBean;

public interface WebReportRepository extends JpaRepository<WebReportBean, String> {

}
