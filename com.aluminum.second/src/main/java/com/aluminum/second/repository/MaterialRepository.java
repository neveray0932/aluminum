package com.aluminum.second.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.aluminum.second.domain.MaterialBean;





public interface MaterialRepository extends JpaRepository<MaterialBean, String> {
	
	

}
