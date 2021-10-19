package com.aluminum.second.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.aluminum.second.domain.CustomerBean;



public interface CustomerRepository extends JpaRepository<CustomerBean, Integer> {
	@Transactional
	@Query("SELECT c FROM CustomerBean c where c.customer like %?1%"
			+ " or c.address like %?1% or c.tel like %?1% or c.fax like %?1%"
			+ " or c.contact like %?1% or c.taxnumber like %?1%"
			)
	List<CustomerBean> findByAnything(String anythig);
	
	List<CustomerBean> findByAddress(String address);
	List<CustomerBean> findByAddressLike(String address);
	
	
	

}
