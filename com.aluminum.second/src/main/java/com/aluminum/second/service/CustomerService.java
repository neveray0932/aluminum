package com.aluminum.second.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluminum.second.domain.CustomerBean;
import com.aluminum.second.repository.CustomerRepository;



@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository custdao;
	
	public CustomerBean insert(CustomerBean bean) {
		CustomerBean result = null;
		if(bean!=null) {
//			if(!custdao.existsById(bean.getCustomerid())) {
			
				System.out.println(bean.getCustomerid());
				result=custdao.save(bean);
//			}
		}
				
		return result;
	}
	public CustomerBean update(CustomerBean bean) {
		CustomerBean result = null;
		if(bean!=null) {
			if(custdao.existsById(bean.getCustomerid())) {
				result = custdao.save(bean);
				return result;
			}
		}
		
		return result;
	}
	
	public boolean delete(CustomerBean bean) {
		boolean result = false;
		if(bean!=null && bean.getCustomerid()!=null) {
			if(custdao.existsById(bean.getCustomerid())) {
				custdao.delete(bean);
				result=true;
			}
		}
		return result;
	}
	public List<CustomerBean> findByAnything(String anythig) {
		List<CustomerBean> result = null;
		result = new ArrayList<CustomerBean>();
		 result =custdao.findByAnything(anythig);
		 
		 return result;
	}
}
