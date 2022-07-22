package com.stage.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stage.demo.model.PostEntity;

import com.stage.demo.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	// get all Posts

	@GetMapping
	ResponseEntity<List<PostEntity>> getALLPosts() {

		List<PostEntity> Posts = postService.getAllPost();
		logger.debug("inside PostController.getAllPosts() method");
		return ResponseEntity.ok(Posts);
	}

	@PostMapping
	ResponseEntity<String> AddPost(@RequestBody PostEntity post) {
		postService.AddPost(post);
		return ResponseEntity.ok("Post Added Successfully ");
	}

	@DeleteMapping("{id}")
	ResponseEntity<String> delete(PostEntity c) {

		postService.deletePost(c);
		return ResponseEntity.ok("PostDeleted");
	}

}
