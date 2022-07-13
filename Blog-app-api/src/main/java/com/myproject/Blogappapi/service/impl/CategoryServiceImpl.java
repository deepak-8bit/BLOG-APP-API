package com.myproject.Blogappapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.Blogappapi.Exception.ResourceNotFoundException;
import com.myproject.Blogappapi.modal.Category;
import com.myproject.Blogappapi.modal.User;
import com.myproject.Blogappapi.payloads.CategoryDto;
import com.myproject.Blogappapi.payloads.UserDto;
import com.myproject.Blogappapi.repositories.CategoryRepo;
import com.myproject.Blogappapi.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public CategoryRepo categoryRepo;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = modelMapper.map(categoryDto, Category.class);
		Category addedcat =categoryRepo.save(cat);
		
		return modelMapper.map(addedcat, CategoryDto.class);
		
		 
		
		
//		Category category = this.dtoToCategory(categoryDto);
//		Category saveduser =this.categoryRepo.save(category);
//		
//		return this.categoryToDto(saveduser) ;
	}
	
	
	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat =categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","CategoryTitle",categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatecat = categoryRepo.save(cat);
		
		
		return modelMapper.map(updatecat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat =categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryTitle", categoryId));
		categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getByIdCategory(Integer categoryId) {
		Category cat =categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryTitle", categoryId));

	return	modelMapper.map(cat, CategoryDto.class);
		
	}

	@Override
	public List<CategoryDto> getallCategory() {
		
		List<Category> categories =categoryRepo.findAll();

		List<CategoryDto> catDtos =   categories.stream().map((cat)->modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());		
		
		
		return catDtos;
	}
	
	
	
	
	
//	used mapper  for converting 
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		Category category =modelMapper.map(categoryDto, Category.class);
		
		return category;
	}
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto =modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

}
