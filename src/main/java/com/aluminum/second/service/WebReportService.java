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
	
	//報表全部查詢
	public List<WebReportBean> selectAll() {
		return webReportRepository.findAll();
	}
	//報表新增
	public WebReportBean insert(WebReportBean bean) {
		WebReportBean result = null;
		if(bean!=null) {
			result = webReportRepository.save(bean);
		}
		return result;
	}
	//報表修改
	public WebReportBean update(WebReportBean bean) {
		WebReportBean result = null;
		if(bean!=null&&bean.getReportid()!=null) {
			if(webReportRepository.existsById(bean.getReportid())) {
				result = webReportRepository.save(bean);
			}
		}
		return result;
	}
	//報表單筆刪除
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
