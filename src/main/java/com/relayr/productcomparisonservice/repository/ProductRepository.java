package com.relayr.productcomparisonservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relayr.productcomparisonservice.model.Category;
import com.relayr.productcomparisonservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	List<Product> findByNameContainingAndCategory(String pName , Category cat);
	
}
