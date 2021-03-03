package com.accoliteAU.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Correct_Categories")
public class Category {
	@Id
	@Column(name = "catid")
	private int categoryId;
	@Column(name = "catname", length = 10)
	private String categoryName;
	@ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
	@JoinTable(name = "categories_items", 
	joinColumns = @JoinColumn(referencedColumnName = "catid"), 
	inverseJoinColumns = @JoinColumn(referencedColumnName = "itemid"))
	private Set<Item> items;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> s) {
		this.items = s;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryname) {
		this.categoryName = categoryname;
	}

}