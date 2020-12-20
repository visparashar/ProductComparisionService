package com.relayr.productcomparisonservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relayr.productcomparisonservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Category findByCategoryname(String categoryname);
	Category findByCategorynameContaining(String categoryname);

}
