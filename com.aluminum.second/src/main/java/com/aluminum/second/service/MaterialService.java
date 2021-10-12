package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluminum.second.domain.MaterialBean;
import com.aluminum.second.repository.MaterialRepository;



@Service
public class MaterialService {
	
	//注入
	@Autowired
	private MaterialRepository materialdao;
	
	//材料查詢
	public List<MaterialBean> selectAll(){
		List<MaterialBean> result = materialdao.findAll();
		
		return result;
	}
	//材料新增
	public MaterialBean insert(MaterialBean bean) {
		MaterialBean result = null;
		if(bean!=null) {
			if(!materialdao.existsById(bean.getMaterialid())) {
				result = materialdao.save(bean);
				return result;
			}else {
				result =update(bean);
			}
			
		}
		return result;
	}
	//材料更新
	public MaterialBean update(MaterialBean bean) {
		MaterialBean result = null;
		if(bean!=null) {
			if(materialdao.existsById(bean.getMaterialid())) {
				result = materialdao.save(bean);
			}
		}
		return result;
	}
	//材料刪除
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
