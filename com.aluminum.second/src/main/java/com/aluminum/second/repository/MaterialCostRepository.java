package com.aluminum.second.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.aluminum.second.domain.MaterialCostBean;
import com.aluminum.second.domain.MaterialCostBean.ConfigId;
import com.aluminum.second.domain.MaterialCostJoin;
import com.aluminum.second.domain.MaterialJoinSpec;
import com.aluminum.second.domain.SpecPriceBean;



public interface MaterialCostRepository extends JpaRepository<MaterialCostBean,ConfigId> {

	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.SpecPriceBean(SUM(mcb.total), mcb.specfk.specid) FROM MaterialCostBean mcb"
			+ " JOIN mcb.specfk "
			+ "GROUP BY mcb.specfk.specid"
			)
	List<SpecPriceBean> selectSpecPrice();
	
	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.SpecPriceBean(SUM(mcb.total), mcb.specfk.specid) FROM MaterialCostBean mcb"
			+ " JOIN mcb.specfk "
			+" WHERE mcb.doorjudge = '門扇' "
			+ "GROUP BY mcb.specfk.specid"
			)
	List<SpecPriceBean> selectDoorLeafPrice();
	
	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.SpecPriceBean(SUM(mcb.total), mcb.specfk.specid) FROM MaterialCostBean mcb"
			+ " JOIN mcb.specfk "
			+" WHERE mcb.doorjudge = '門框' "
			+ "GROUP BY mcb.specfk.specid"
			)
	List<SpecPriceBean> selectFramePrice();
	
	
	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.MaterialJoinSpec"
			+ "(mcb.specfk.specid, mcb.materialfk.materialid, mcb.materialfk.unitprice, mcb.dosage, mcb.total) "
			+ "FROM MaterialCostBean mcb"
			+ " JOIN mcb.materialfk"
			+ " JOIN mcb.specfk ORDER BY mcb.specfk.specid"
			)
	List<MaterialJoinSpec> selectJoin();
	
	@Transactional
	@Query("SELECT NEW com.aluminum.second.domain.MaterialCostJoin"
			+ "(mcb.specfk.specid, mcb.materialfk.materialid, mcb.dosage, mcb.materialfk.cost, (mcb.dosage*mcb.materialfk.cost)) "
			+ "FROM MaterialCostBean mcb"
			+ " JOIN mcb.materialfk"
			+ " JOIN mcb.specfk "
			+ "WHERE mcb.specfk.specid =?1"
			)
	List<MaterialCostJoin> materialCostJoin(String specid);
	
}
