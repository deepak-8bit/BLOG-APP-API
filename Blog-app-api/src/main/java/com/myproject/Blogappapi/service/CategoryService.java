package com.myproject.Blogappapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.Blogappapi.payloads.CategoryDto;

@Service
public interface CategoryService {
	
	public CategoryDto createCategory(CategoryDto categoryDto);

	
	
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

	
	
	public void deleteCategory(Integer categoryId);
	
	public CategoryDto getByIdCategory(Integer categoryId);
	
	public List<CategoryDto> getallCategory();


	
	

	

}
