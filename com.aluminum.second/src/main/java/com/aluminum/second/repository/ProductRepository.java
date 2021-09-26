package com.aluminum.second.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluminum.second.domain.ProductBean;

public interface ProductRepository extends JpaRepository<ProductBean, String> {

	

}
