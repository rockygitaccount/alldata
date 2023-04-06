package com.boggingApp.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boggingApp.Entity.Category;
import com.boggingApp.Entity.Post;
import com.boggingApp.Entity.User;
import com.boggingApp.Exceptions.ResourceNotFoundException;
import com.boggingApp.Payloads.PostDto;
import com.boggingApp.Payloads.PostResponse;
import com.boggingApp.Repositories.CategoryRepository;
import com.boggingApp.Repositories.PostRepository;
import com.boggingApp.Repositories.UserRepository;
import com.boggingApp.Services.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
	  User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		Post post = modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost = postRepository.save(post);
		return modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		 Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("PostDto", "postId", postId));
		 post.setTitle(postDto.getTitle());
		 post.setContent(postDto.getContent());
		 post.setImageName(postDto.getImageName());
		 Post updatedPost = postRepository.save(post);
		return modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
	postRepository.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {

		
		PageRequest p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		 Page<Post> pagePost = postRepository.findAll(p);
		 List<Post> allPost = pagePost.getContent();
		List<PostDto> postDtos = allPost.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElement(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post posts = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("PostDto", "postId", postId));
		return modelMapper.map(posts, PostDto.class);
	}



//	@Override
//	public List<PostDto> findByTitleContaining(String keyword) {
//		List<Post> posts = postRepository.findByTitleContaining(keyword);
//		List<PostDto> postDto = posts.stream().map((post)-> modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
//		return postDto;
//	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
	
		Category cat = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category"
				, "category id", categoryId));
		List<Post> posts = postRepository.findByCategory(cat);
		List<PostDto> postDtos = posts.stream().map((post)-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts = postRepository.findByUser(user);
		List<PostDto> postsDtos = posts.stream().map((post)-> modelMapper.map(post, PostDto.class )).collect(Collectors.toList());
		
		return postsDtos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
