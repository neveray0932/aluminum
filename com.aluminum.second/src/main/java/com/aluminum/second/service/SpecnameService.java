package com.aluminum.second.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluminum.second.domain.SpecnameBean;
import com.aluminum.second.repository.SpecnameRepository;

@Service
public class SpecnameService {
	@Autowired
	private SpecnameRepository specnameRepository;

	public Optional<SpecnameBean> selectOne(SpecnameBean bean) {
		Optional<SpecnameBean> result = null;
		if (bean != null && bean.getSpecid() != null) {
			result = specnameRepository.findById(bean.getSpecid());
			
		}
		return result;
	}

	public List<SpecnameBean> selectAll() {
		List<SpecnameBean> result = specnameRepository.findAll();

		return result;
	}

	public SpecnameBean insert(SpecnameBean bean) {
		SpecnameBean result = null;
		
		if (bean != null) {
			if(!specnameRepository.existsById(bean.getSpecid())) {
				result = specnameRepository.save(bean);
			}
			

		}
		return result;

	}

	public SpecnameBean update(SpecnameBean bean) {
		SpecnameBean result = null;
		if (bean != null) {
			if (specnameRepository.existsById(bean.getSpecid())) {
				System.out.println("ok");
				result = specnameRepository.save(bean);
			}
		}
		return result;
	}

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
