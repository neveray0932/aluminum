package com.aluminum.second.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="material_category")
@Data 
public class MaterialCategoryBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer materialcategoryid;
	private String category;
}
