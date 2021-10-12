package com.aluminum.second.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.aluminum.second.domain.ProdSpecBean;

import com.aluminum.second.domain.ProdSpecBean.ConfigId;
import com.aluminum.second.domain.ProdSpecClc;
import com.aluminum.second.domain.ProdSpecFind;
import com.aluminum.second.domain.ProdSpecJoin;

public interface ProdSpecRepository extends JpaRepository<ProdSpecBean, ConfigId> {
	
	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.ProdSpecClc(psb.prodid, ROUND(SUM(psb.price)*psb.coefficient,0) ) FROM ProdSpecBean psb"
			
			+ " GROUP BY psb.prodid, psb.coefficient"
			)
	List<ProdSpecClc> selectPrice();
	
	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.ProdSpecFind(psb.prodid, psb.specid, psb.coefficient, psb.price ) FROM ProdSpecBean psb"
			+ " WHERE psb.specid=?1"
			
			
			)
	List<ProdSpecFind> findSpecUsed(String specid);
	
	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.ProdSpecJoin(psb.prodid, psb.specid, psb.coefficient, psb.price, psb.products.prodmark, psb.specs.doorinfofks.doorinfo) FROM ProdSpecBean psb"
			+ " JOIN psb.specs"
			+ " JOIN psb.products"
			+ " JOIN psb.specs.doorinfofks"
			+ " WHERE psb.prodid=?1"
			
			
			)
	List<ProdSpecJoin> prodSpecJoin(String prodid);
	

}
