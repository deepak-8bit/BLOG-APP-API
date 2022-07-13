package com.myproject.Blogappapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.Blogappapi.modal.Category;
import com.myproject.Blogappapi.modal.Post;
import com.myproject.Blogappapi.modal.User;

public interface PostRepo  extends JpaRepository<Post, Integer>{
	
	
	 List<Post> findByUser(User user);
	 
	 List<Post> findByCategory(Category category);

}
