package com.relayr.productcomparisonservice.datasource.processor;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.relayr.productcomparisonservice.model.Product;
import com.relayr.productcomparisonservice.repository.ProductRepository;
@Component
public class DBWriter implements ItemWriter<Product> {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void write(List<? extends Product> arg0) throws Exception {

		System.out.println("Data Saving for Products ");
		productRepository.saveAll(arg0);
	}
	
	
	

}
