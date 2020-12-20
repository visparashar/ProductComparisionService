package com.relayr.productcomparisonservice.service;

import java.util.List;

import com.relayr.productcomparisonservice.exceptions.CategoryNotFoundException;
import com.relayr.productcomparisonservice.model.Product;


public interface ProductSearchSerivce {
	
	
	List<Product> getProductWithCategory(String name , String categoryName) throws CategoryNotFoundException;
	
	Product getProduct(Long id);
	
	Product getProductByName(String name);
	
	
	// there can be more method under this service related with product search
	

}
