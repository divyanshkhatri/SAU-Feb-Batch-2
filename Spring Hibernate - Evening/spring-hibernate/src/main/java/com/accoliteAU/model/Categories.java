package com.accoliteAU.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int categoryId;
	
	String categoryName;
	
	@ManyToOne
	Product product;
	
	@ManyToMany(mappedBy = "categories")
	List<Supplier> supplier = new ArrayList<>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String string) {
		this.categoryName = string;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Supplier> getSupplier() {
		return supplier;
	}

	public void setSupplier(List<Supplier> supplier) {
		this.supplier = supplier;
	}
	
}
