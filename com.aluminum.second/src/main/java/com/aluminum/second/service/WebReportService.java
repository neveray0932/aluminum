package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluminum.second.domain.WebReportBean;
import com.aluminum.second.repository.WebReportRepository;

@Service
public class WebReportService {
	
	@Autowired
	private WebReportRepository webReportRepository;
	
	public List<WebReportBean> selectAll() {
		return webReportRepository.findAll();
	}
	
	public WebReportBean insert(WebReportBean bean) {
		WebReportBean result = null;
		if(bean!=null) {
			result = webReportRepository.save(bean);
		}
		return result;
	}
	
	public WebReportBean update(WebReportBean bean) {
		WebReportBean result = null;
		if(bean!=null&&bean.getReportid()!=null) {
			if(webReportRepository.existsById(bean.getReportid())) {
				result = webReportRepository.save(bean);
			}
		}
		return result;
	}
	
	public boolean delete(WebReportBean bean) {
		boolean result = false;
		if(bean!=null&&bean.getReportid()!=null) {
			if(webReportRepository.existsById(bean.getReportid())) {
				webReportRepository.delete(bean);
				result =true;
			}
		}
		return result;
	}

}
