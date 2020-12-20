package com.relayr.productcomparisonservice.service.impl;

import static org.mockito.ArgumentMatchers.anyString;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.relayr.productcomparisonservice.model.Category;
import com.relayr.productcomparisonservice.model.Product;
import com.relayr.productcomparisonservice.repository.ProductRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductSearchServiceTest {
	
	 @Mock
	    ProductRepository productRepository;

	    @InjectMocks
	    ProductSearchServiceImpl productSearchService;

		@Before
	    public void setup() {
	        List<Product> products = new LinkedList<>();
	        
	        Category cat = new Category();
	        cat.setCategoryname("mobilephone");
	        
	        Product first = new Product();
	        first.setName("Sample1");
	        first.setDescription("Sample description");
	        first.setCategory(cat);
	        first.setId(1l);
	        products.add(first);

	        Mockito.when(((OngoingStubbing) productRepository.findByNameContainingAndCategory(anyString(), cat))
	                .thenReturn(products));
	    }

	  

}
