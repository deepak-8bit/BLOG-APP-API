package com.myproject.Blogappapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.Blogappapi.modal.Post;
import com.myproject.Blogappapi.payloads.PostDto;
import com.myproject.Blogappapi.repositories.PostRepo;
import com.myproject.Blogappapi.service.PostService;
@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepo repo;
	
	
	public Post createPost(PostDto postDto) {
		
		return null;
	}

	public Post updatedPost(PostDto postDto, Integer postId) {
		
		return null;
	}

	public Post deletePost(Integer postId) {
		
		return null;
	}

	public List<Post> getAllPost() {
		
		return null;
	}

	public Post getPostById(Integer postId) {
		
		return null;
	}

	public List<Post> getPostsByCategory(Integer categoryId) {
		
		return null;
	}

	public List<Post> getPostByUser(Integer userId) {
		
		
		return null;
	}

	public List<Post> searchPost(String keyword) {
		
		return null;
	}

}
