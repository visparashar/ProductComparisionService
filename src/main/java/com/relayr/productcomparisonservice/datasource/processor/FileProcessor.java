package com.relayr.productcomparisonservice.datasource.processor;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.relayr.productcomparisonservice.model.Category;
import com.relayr.productcomparisonservice.model.Product;
import com.relayr.productcomparisonservice.pojo.ProductDTO;
import com.relayr.productcomparisonservice.repository.CategoryRepository;

@Component
public class FileProcessor implements ItemProcessor<ProductDTO, Product>{

	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Product process(ProductDTO dto) throws Exception {
		//get product object from productdto 
		Product product =dto._toProduct();
		Category category =categoryRepository.findByCategoryname(dto.getCategory_name().replaceAll("\\s", "").toLowerCase());
		if(category!=null) {
			product.setCategory(category);
		}else {
			Category category1 = new Category();
			category1.setCategoryname(dto.getCategory_name().replaceAll("\\s", "").toLowerCase());
			Category cat =categoryRepository.save(category1);
			
			product.setCategory(cat);
			
		}
		
		return product;
	}

}
