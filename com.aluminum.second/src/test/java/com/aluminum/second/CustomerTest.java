//package com.aluminum.second;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.aluminum.second.domain.CustomerBean;
//import com.aluminum.second.repository.CustomerRepository;
//
//@SpringBootTest
//public class CustomerTest {
//	@Autowired
//	CustomerRepository customerRepository;
//	
//	//@Test
//	public void method() {
//		customerRepository.findByAddress("%台%");
//		System.out.println(customerRepository.findByAddressLike("%台%"));
//	}
//	//@Test
//	public void methods() {
//		List<CustomerBean> result =customerRepository.findByAnything("23");
//		System.out.println(result);
//	}
//	@Test
//	@Transactional
//	public void find() {
//		;
//		System.out.println(customerRepository.findAll());
//	}
//
//}
