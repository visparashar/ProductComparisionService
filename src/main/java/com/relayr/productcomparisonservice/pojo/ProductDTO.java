package com.relayr.productcomparisonservice.pojo;

import org.springframework.stereotype.Component;

import com.relayr.productcomparisonservice.model.Product;

@Component
public class ProductDTO {
	
	private String productname;
	
	private String description;
	
	private String siteurl;
	
	private String sitename;
	
	private Double amount;
	
	private String category_name;

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public Product _toProduct() {
		Product product = new Product();
		product.setAmount(this.amount);
		product.setDescription(this.description);
		product.setName(this.productname);
		product.setSitename(this.sitename);
		product.setUrl(this.siteurl);
		
		
		return product;
	}

}
