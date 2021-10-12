package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.aluminum.second.domain.ProdSpecBean;
import com.aluminum.second.domain.ProdSpecBean.ConfigId;
import com.aluminum.second.repository.ProdSpecRepository;

@Service
public class ProdSpecService {
	
	@Autowired
	ProdSpecRepository prodSpecRepository;
	//產品規格的組合多筆刪除
	public boolean deleteAll(List<ProdSpecBean> beans) {
		ConfigId id = new ConfigId();
		id.setProdid(beans.get(0).getProdid());
		id.setSpecid(beans.get(0).getSpecid());
		boolean result = false;
		if(!beans.isEmpty()) {
			if(prodSpecRepository.existsById(id)) {
				prodSpecRepository.deleteAll(beans);
				result =true;
			}
		}
		return result;

	}

}
