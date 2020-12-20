package com.relayr.productcomparisonservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.relayr.productcomparisonservice.exceptions.CategoryNotFoundException;
import com.relayr.productcomparisonservice.model.Product;
import com.relayr.productcomparisonservice.service.ProductSearchSerivce;
import com.relayr.productcomparisonservice.util.ResponseGenerationUtil;

@RestController
@RequestMapping("/api/v1")
public class SearchRestController {
	
	
	@Autowired
	ProductSearchSerivce productSearchService;
	
	
	
	
	@GetMapping("/search")
	public ResponseEntity<Object> search(@RequestParam("pname") String pname , @RequestParam("category") String category){
	
		//check if required params are present or not 
		if(StringUtils.isEmpty(category)|| StringUtils.isEmpty(pname)) {
			//error message
			return ResponseEntity.badRequest().body(ResponseGenerationUtil.generateResponse(false, "Mandatory Param Missing", null));
		}
		
		try {
			List<Product>  product =productSearchService.getProductWithCategory(pname, category);
			if(product!=null && !product.isEmpty()) {
				return ResponseEntity.ok(ResponseGenerationUtil.generateResponse(true, "Product List", product));
			}else {
				return ResponseEntity.ok(ResponseGenerationUtil.generateResponse(false, "No Product Info Found", null));
				
			}
		} catch (CategoryNotFoundException e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(ResponseGenerationUtil.generateResponse(false, "Currently Not Data found for "+category, null));
		}
		
		
		
		
	}

}
