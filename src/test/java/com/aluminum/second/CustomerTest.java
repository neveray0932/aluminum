//package com.aluminum.second;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.aluminum.second.domain.CustomerBean;
//import com.aluminum.second.domain.ReportDetailBean;
//import com.aluminum.second.domain.WebReportBean;
//import com.aluminum.second.repository.CustomerRepository;
//import com.aluminum.second.repository.WebReportRepository;
//
//@SpringBootTest
//public class CustomerTest {
//	@Autowired
//	CustomerRepository customerRepository;
//	@Autowired
//	WebReportRepository webReportRepository;
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
//	//@Test
//	@Transactional
//	public void find() {
//		;
//		System.out.println(customerRepository.findAll());
//	}
//	
//	//@Test
//	public void abc() {
//		CustomerBean cust = new CustomerBean();
//		
//		
//		cust.setCustomerid(20);
//		cust.setCustomer("AV攝象有限公司");
//		WebReportBean report = new WebReportBean();
//		report.setReportid("Q20210929007");
//		report.setReportdate(new Date());
//		report.setWorkaddress("AV女優集散地");
//		
//		report.setCustomerfk(cust);
//		
//		webReportRepository.save(report);
//		
//		
//		
//		
//		
//	}
//
//}
