//package com.aluminum.second;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.aluminum.second.domain.MaterialCostBean;
//import com.aluminum.second.domain.MaterialCostBean.ConfigId;
//import com.aluminum.second.domain.ProductBean;
//import com.aluminum.second.domain.SpecnameBean;
//import com.aluminum.second.repository.MaterialCostRepository;
//import com.aluminum.second.repository.ProdSpecRepository;
//import com.aluminum.second.repository.ProductRepository;
//import com.aluminum.second.repository.SpecnameRepository;
//
//@SpringBootTest
//@Transactional
//public class MaterialCostTest {
//	
//	@Autowired
//	private MaterialCostRepository materialCostRepository;
//	@Autowired
//	private ProductRepository productRepository;
//	@Autowired
//	private SpecnameRepository specnameRepository;
//	@Autowired
//	private ProdSpecRepository prodSpecRepository;
//	
//	@Test
//	public void method() {
//		ConfigId id = new ConfigId();
//		
////		prodSpecRepository.findById(id)
////		System.out.println(id);
//		MaterialCostBean bean = new MaterialCostBean();
//		
//		List<MaterialCostBean> result= materialCostRepository.findAll();
//		System.out.println(result);
//		
//	}
//	//@Test
//	@Rollback(false)
//	public void method1() {
//		
//		
//		
//		//主
//		SpecnameBean spbean = new SpecnameBean();
//		spbean.setSpecid(20);
////		spbean.setProdname("EE");
////		spbean.setSpecname("EE");
////		specnameRepository.save(spbean);
//		
//		
////		ProductBean bean = new ProductBean();
//		
////		bean.setProdid(1);
//		bean.setProdname("test");
//		bean.setProdprice(777);
////		bean.setProdspecfk(spbean);
////		spbean.getProducts().add(bean);
////		specnameRepository.save(spbean);
//		System.out.println(spbean);
//		
//		
////		
//		
//		productRepository.save(bean);
//		
////		System.out.println(productRepository.findById(1));
//		;
//	}
//
//}
