package com.boggingApp.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boggingApp.Entity.Category;
import com.boggingApp.Exceptions.ResourceNotFoundException;
import com.boggingApp.Payloads.CategoryDto;
import com.boggingApp.Repositories.CategoryRepository;
import com.boggingApp.Services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = modelMapper.map(categoryDto, Category.class);
		Category addedCat = categoryRepository.save(cat);
		
		return modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id" ,categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat = categoryRepository.save(cat);
		return modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory( ) {

	List<Category> categories = categoryRepository.findAll();
	List<CategoryDto> catDtos = categories.stream().map((cat)-> modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
	
		
		return catDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category cat = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
	categoryRepository.delete(cat);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {

		Category cat = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
		return modelMapper.map(cat, CategoryDto.class);
	}

}
