package com.aluminum.second.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluminum.second.domain.SpecnameBean;
import com.aluminum.second.repository.SpecnameRepository;

@Service
@Transactional
public class SpecnameService {
	@Autowired
	private SpecnameRepository specnameRepository;
	
	//規格單筆查詢
	public Optional<SpecnameBean> selectOne(SpecnameBean bean) {
		Optional<SpecnameBean> result = null;
		if (bean != null && bean.getSpecid() != null) {
			result = specnameRepository.findById(bean.getSpecid());
			
		}
		return result;
	}

	//規格全部查詢
	public List<SpecnameBean> selectAll() {
		List<SpecnameBean> result = specnameRepository.findAll();

		return result;
	}
	//規格新增
	public SpecnameBean insert(SpecnameBean bean) {
		SpecnameBean result = null;
		
		if (bean != null) {
			if(!specnameRepository.existsById(bean.getSpecid())) {
				result = specnameRepository.save(bean);
			}
			
			

		}
		System.out.println("insert"+result);
		return result;

	}
	//規格全部修改
	public SpecnameBean update(SpecnameBean bean) {
		SpecnameBean result = null;
		if (bean != null) {
			if (specnameRepository.existsById(bean.getSpecid())) {
				System.out.println("ok");
				result = specnameRepository.save(bean);
				System.out.println("0"+result);
			}
		}
		return result;
	}
	//規格單筆刪除
	public boolean delete(SpecnameBean bean) {
		boolean result = false;
		if (bean != null) {
			if (specnameRepository.existsById(bean.getSpecid())) {
				specnameRepository.delete(bean);
				result = true;
			}
		}
		return result;
	}

}
