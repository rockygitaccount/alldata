package com.boggingApp.Services;

import java.util.List;

import com.boggingApp.Payloads.CategoryDto;

public interface CategoryService {
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	public List<CategoryDto> getAllCategory( );
	void deleteCategory(Integer categoryId);
	public CategoryDto getCategoryById(Integer categoryId);
	

}
