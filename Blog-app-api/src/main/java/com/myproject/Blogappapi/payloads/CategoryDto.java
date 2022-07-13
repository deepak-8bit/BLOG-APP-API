package com.myproject.Blogappapi.payloads;

import javax.validation.constraints.NotNull;

public class CategoryDto {
	private Integer categoryId;
	
	
	@NotNull(message = "Ctitle should must have value")
	private String categoryTitle;
	
	@NotNull
	private String categoryDescription;

	
	
	

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + "]";
	}





	public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}





	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryTitle() {
		return categoryTitle;
	}


	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}


	public String getCategoryDescription() {
		return categoryDescription;
	}


	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}


	
	
	
	
	
}
