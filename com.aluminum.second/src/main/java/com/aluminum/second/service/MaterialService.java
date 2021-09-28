package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluminum.second.domain.MaterialBean;
import com.aluminum.second.repository.MaterialRepository;



@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialdao;
	
	public List<MaterialBean> selectAll(){
		List<MaterialBean> result = materialdao.findAll();
		
		return result;
	}
	
	public MaterialBean insert(MaterialBean bean) {
		MaterialBean result = null;
		if(bean!=null) {
			result = materialdao.save(bean);
			return result;
		}
		return result;
	}
	
	public MaterialBean update(MaterialBean bean) {
		MaterialBean result = null;
		if(bean!=null) {
			if(materialdao.existsById(bean.getMaterialid())) {
				result = materialdao.save(bean);
			}
		}
		return result;
	}
	public boolean delete(MaterialBean bean) {
		boolean result =false;
		if(bean!=null) {
			if(materialdao.existsById(bean.getMaterialid())) {
				materialdao.delete(bean);
				result = true;
			}
		}
		return result;
	}
}
