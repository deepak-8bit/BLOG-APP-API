package com.myproject.Blogappapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.Blogappapi.payloads.ApiResponse;
import com.myproject.Blogappapi.payloads.CategoryDto;
import com.myproject.Blogappapi.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto){
		
		return new ResponseEntity<CategoryDto>(service.createCategory(categoryDto) , HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updatedcategory( @Valid  @RequestBody CategoryDto categoryDto, @PathVariable  Integer categoryId){
		
		return new ResponseEntity<CategoryDto>(service.updateCategory(categoryDto, categoryId), HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		service.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true) ,HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getByIdcategory(@PathVariable Integer categoryId){
		return new ResponseEntity<CategoryDto>(service.getByIdCategory(categoryId) ,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){

		return ResponseEntity.ok(service.getallCategory());
	
	}

}
