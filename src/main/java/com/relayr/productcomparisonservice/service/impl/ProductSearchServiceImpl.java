package com.relayr.productcomparisonservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relayr.productcomparisonservice.exceptions.CategoryNotFoundException;
import com.relayr.productcomparisonservice.model.Category;
import com.relayr.productcomparisonservice.model.Product;
import com.relayr.productcomparisonservice.repository.CategoryRepository;
import com.relayr.productcomparisonservice.repository.ProductRepository;
import com.relayr.productcomparisonservice.service.ProductSearchSerivce;

@Service
public class ProductSearchServiceImpl implements ProductSearchSerivce{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getProductWithCategory(String name, String categoryName) throws CategoryNotFoundException {
		//check if we have category information in system or not 
		// for this poc we will return the error but in actual system we should have should system where we can 
//		initiate a request to have some data for defined category
		
		Category category = categoryRepository.findByCategorynameContaining(categoryName.replaceAll("\\s", "").toLowerCase());
		if(category ==null) {
			//triggering exepection of categorynot found
			throw new CategoryNotFoundException();
		}
		
		return productRepository.findByNameContainingAndCategory(name, category);
		
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
