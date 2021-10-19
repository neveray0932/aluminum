package com.aluminum.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluminum.second.domain.MaterialCostBean;
import com.aluminum.second.domain.MaterialCostBean.ConfigId;
import com.aluminum.second.domain.SpecPriceBean;
import com.aluminum.second.repository.MaterialCostRepository;

@Service
@Transactional
public class MaterialCostService {

	@Autowired
	private MaterialCostRepository materialCostRepository;

	//材料與規格的組合查詢
	public List<MaterialCostBean> findAll() {
		List<MaterialCostBean> result = materialCostRepository.findAll(Sort.by(Sort.Direction.ASC, "specid"));
		return result;
	}
	//材料與規格的組合價格查詢(全部)
	public List<SpecPriceBean> selectSpecPrice() {
		List<SpecPriceBean> result = materialCostRepository.selectSpecPrice();
		return result;
	}
	//材料與規格的組合價格查詢(門扇)
	public List<SpecPriceBean> selectDoorLeafPrice() {
		List<SpecPriceBean> result = materialCostRepository.selectDoorLeafPrice();
		return result;
	}
	//材料與規格的組合價格查詢(門框)
	public List<SpecPriceBean> selectFramePrice() {
		List<SpecPriceBean> result = materialCostRepository.selectFramePrice();
		return result;
	}
	
	
	//材料與規格的組合新增
	public MaterialCostBean insert(MaterialCostBean bean) {
		MaterialCostBean result = null;
		if (bean != null) {
			result = materialCostRepository.save(bean);
		}

		return result;
	}
	//材料與規格的組合多筆新增
	public List<MaterialCostBean> insertAll(List<MaterialCostBean> beans) {
		List<MaterialCostBean> result = null;
		if (beans != null) {
			result = materialCostRepository.saveAll(beans);
		}
		return result;
	}
	//材料與規格的組合單筆刪除
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
	//材料與規格的組合多筆刪除
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
	//材料與規格的組合修改
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
	//材料與規格的組合多筆修改
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
