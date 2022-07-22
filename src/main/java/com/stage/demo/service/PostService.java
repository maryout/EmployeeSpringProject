package com.stage.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.demo.model.PostEntity;
import com.stage.demo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public PostEntity AddPost(PostEntity c) {
		return postRepository.save(c);
	}

	public List<PostEntity> getAllPost() {
		return postRepository.findAll();
	}

	public PostEntity getPost(Long id) {
		return postRepository.findById(id).get();
	}

	public void deletePost(PostEntity c) {
		postRepository.delete(c);
	}

	public void deletePostById(Long id) {
		postRepository.deleteById(id);
	}

	public List<PostEntity> getPostByTitle(String title) {

		return postRepository.findByTitle(title);
	}

}
