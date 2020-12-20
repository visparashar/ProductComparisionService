package com.relayr.productcomparisonservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="category")
public class Category extends BaseModel{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String categoryname;
	
	 @OneToMany(
		        mappedBy = "category", 
		        cascade = CascadeType.ALL, 
		        fetch= FetchType.EAGER,
		        orphanRemoval = true
		    )
	 @JsonBackReference
	private List<Product> product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	


}
