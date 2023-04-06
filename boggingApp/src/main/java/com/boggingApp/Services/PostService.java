package com.boggingApp.Services;

import java.util.List;

import com.boggingApp.Payloads.PostDto;
import com.boggingApp.Payloads.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	//delete
	void deletePost(Integer postId);
	//get all posts
	PostResponse getAllPost(Integer pageNumber, Integer PageSize, String sortBy);
	//get single posts 
	PostDto getPostById(Integer postId);
	//get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	//get all post by user
	List<PostDto> getPostByUser(Integer userId);
//	//search posts
//	List<PostDto> findByTitleContaining(String keyword);
	
	
	
	
	
	
	
}
