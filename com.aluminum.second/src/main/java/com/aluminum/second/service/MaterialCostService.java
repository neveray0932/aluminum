package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aluminum.second.domain.MaterialCostBean;
import com.aluminum.second.domain.MaterialCostBean.ConfigId;
import com.aluminum.second.domain.SpecPriceBean;
import com.aluminum.second.repository.MaterialCostRepository;

@Service
public class MaterialCostService {

	@Autowired
	private MaterialCostRepository materialCostRepository;

	public List<MaterialCostBean> findAll() {
		List<MaterialCostBean> result = materialCostRepository.findAll(Sort.by(Sort.Direction.ASC, "specid"));
		return result;
	}

	public List<SpecPriceBean> selectSpecPrice() {
		List<SpecPriceBean> result = materialCostRepository.selectSpecPrice();
		return result;
	}
	
	public List<SpecPriceBean> selectDoorLeafPrice() {
		List<SpecPriceBean> result = materialCostRepository.selectDoorLeafPrice();
		return result;
	}
	
	public List<SpecPriceBean> selectFramePrice() {
		List<SpecPriceBean> result = materialCostRepository.selectFramePrice();
		return result;
	}
	
	

	public MaterialCostBean insert(MaterialCostBean bean) {
		MaterialCostBean result = null;
		if (bean != null) {
			result = materialCostRepository.save(bean);
		}

		return result;
	}

	public List<MaterialCostBean> insertAll(List<MaterialCostBean> beans) {
		List<MaterialCostBean> result = null;
		if (beans != null) {
			result = materialCostRepository.saveAll(beans);
		}
		return result;
	}

	public boolean delete(MaterialCostBean beans) {
		ConfigId id = new ConfigId();
		id.setMaterialid(beans.getMaterialid());
		id.setSpecid(beans.getSpecid());
		boolean result = false;
		if (beans != null && beans.getMaterialid() != null && beans.getSpecid() != null) {
			if (materialCostRepository.existsById(id)) {
				materialCostRepository.deleteById(id);
			
				result = true;
			}

		}
		return result;

	}
	
	public boolean deleteAll(List<MaterialCostBean> beans) {
		ConfigId id = new ConfigId();
		id.setMaterialid(beans.get(0).getMaterialid());
		id.setSpecid(beans.get(0).getSpecid());
		boolean result = false;
		if(!beans.isEmpty()) {
			if(materialCostRepository.existsById(id)) {
				materialCostRepository.deleteAll(beans);
				result =true;
			}
		}
		return result;

	}
	
	public MaterialCostBean update(MaterialCostBean bean) {
		System.out.println("OK1");
		MaterialCostBean result = null;
		ConfigId id = new ConfigId();
		id.setMaterialid(bean.getMaterialid());
		id.setSpecid(bean.getSpecid());
		if(bean!=null&&bean.getSpecid()!=null) {
			if(materialCostRepository.existsById(id)) {
				result=materialCostRepository.save(bean);
			}
			
		}
		return result;
	}
	public List<MaterialCostBean> updateAll(List<MaterialCostBean> bean) {
		System.out.println("OK2");
		List<MaterialCostBean> result = null;
		ConfigId id = new ConfigId();
		id.setMaterialid(bean.get(0).getMaterialid());
		id.setSpecid(bean.get(0).getSpecid());
		if(bean!=null&&bean.get(0).getSpecid()!=null) {
			if(materialCostRepository.existsById(id)) {
				result=materialCostRepository.saveAll(bean);
			}
			
		}
		return result;
	}
	

}
