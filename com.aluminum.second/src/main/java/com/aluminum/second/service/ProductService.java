package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluminum.second.domain.ProductBean;

import com.aluminum.second.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	//產品新增
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			if(!productRepository.existsById(bean.getProdid())) {
				result= productRepository.save(bean);
			}
			
		}
		
		
		return result;
		
	}
	//產品查詢
	public List<ProductBean> selectAll() {
		return productRepository.findAll();
	}
	//產品修改
	public ProductBean update(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			if(productRepository.existsById(bean.getProdid())) {
				result =productRepository.save(bean);
			}
		}
		return result;
	}
	//產品刪除
	public boolean delete(ProductBean bean) {
		boolean result =false;
		if(bean!=null&&bean.getProdid()!=null) {
			if(productRepository.existsById(bean.getProdid())) {
				productRepository.delete(bean);
				result=true;
			}
		}
		return result;
	}
	

}
