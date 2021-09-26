package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluminum.second.domain.ReportDetailBean;
import com.aluminum.second.domain.ReportJoin;
import com.aluminum.second.domain.ReportDetailBean.ConfigId;
import com.aluminum.second.repository.ReportDetailRepository;

@Service
public class ReportDetailService {

	@Autowired
	private ReportDetailRepository reportDetailRepository ;
	
	public List<ReportDetailBean> selectAll() {
		return reportDetailRepository.findAll();
	}
	
	public List<ReportDetailBean> insertAll(List<ReportDetailBean> beans) {
		List<ReportDetailBean> result =null;
		if(beans!=null&&beans.get(0).getReportid()!=null) {
			result =reportDetailRepository.saveAll(beans);
		}
		return result;
	}
	
	public ReportDetailBean update(ReportDetailBean bean) {
		ReportDetailBean result = null;
		ConfigId id = new ConfigId();
		id.setProdid(bean.getProdid());
		id.setReportid(bean.getReportid());
		if(bean!=null&&bean.getReportid()!=null) {
			if(reportDetailRepository.existsById(id)) {
				result =reportDetailRepository.save(bean);
			}
		}
		return result;
	}
	
	public boolean delete(ReportDetailBean bean) {
		boolean result = false;
		ConfigId id = new ConfigId();
		id.setProdid(bean.getProdid());
		id.setReportid(bean.getReportid());
		if(bean!=null&&bean.getReportid()!=null) {
			if(reportDetailRepository.existsById(id)) {
				reportDetailRepository.delete(bean);
				result = true;
			}
		}
		return result;
	}
	
	public boolean deleteAll(List<ReportDetailBean> beans) {
		boolean result = false;
		ConfigId id = new ConfigId();
		id.setProdid(beans.get(0).getProdid());
		id.setReportid(beans.get(0).getReportid());
		if(beans!=null) {
			if(reportDetailRepository.existsById(id)) {
				reportDetailRepository.deleteAll(beans);
				result =true;
			}
		}
		return result;
	}
	
	public List<ReportJoin> ReportJoin() {
		List<ReportJoin> result =reportDetailRepository.reportJoin();
		return result;
	}
	
	public List<com.aluminum.second.domain.ReportDetailJoinAll> ReportDetailJoinAll(String reportid) {
		return reportDetailRepository.ReportDetailJoinAll(reportid);
	}
	
}
