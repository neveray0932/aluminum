package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluminum.second.domain.MaterialCategoryBean;
import com.aluminum.second.repository.MaterialCategoryRepository;

@Service
public class MaterialCategoryService {
	@Autowired
	private MaterialCategoryRepository materialCategoryRepository;
	
	//材料種類新增
	public MaterialCategoryBean insert(MaterialCategoryBean bean) {
		MaterialCategoryBean result = null;
		if(bean!=null) {
			result =materialCategoryRepository.save(bean);
		}
		
		return result;
	}
	
	//材料種類修改
	public MaterialCategoryBean update(MaterialCategoryBean bean) {
		MaterialCategoryBean result = null;
		if(bean!=null) {
			if(materialCategoryRepository.existsById(bean.getMaterialcategoryid()) )
			result =materialCategoryRepository.save(bean);
		}
		
		return result;
	}
	//材料種類刪除
	public boolean delete(MaterialCategoryBean bean) {
		boolean result = false;
		if(bean!=null) {
			if(materialCategoryRepository.existsById(bean.getMaterialcategoryid()) )
			materialCategoryRepository.deleteById(bean.getMaterialcategoryid());
			result = true;
		}
		
		return result;
	}
	//材料種類查詢
	public List<MaterialCategoryBean> selectAll() {
		List<MaterialCategoryBean> result = null;
		
			result =materialCategoryRepository.findAll();
		
		
		return result;
	}
	//材料種類查看ID是否存在
	public boolean find(Integer id) {
		return materialCategoryRepository.existsById(id);
	}
	

}
