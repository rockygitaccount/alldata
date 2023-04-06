package com.boggingApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boggingApp.Entity.Category;
import com.boggingApp.Entity.Post;
import com.boggingApp.Entity.User;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	//List<Post> findByTitleContaining(String title);
}
