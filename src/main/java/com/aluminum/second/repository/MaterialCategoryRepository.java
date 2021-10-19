package com.aluminum.second.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluminum.second.domain.MaterialCategoryBean;

public interface MaterialCategoryRepository extends JpaRepository<MaterialCategoryBean, Integer> {

}
