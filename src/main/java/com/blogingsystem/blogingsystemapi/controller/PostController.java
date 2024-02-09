package com.blogingsystem.blogingsystemapi.controller;

import com.blogingsystem.blogingsystemapi.payload.PostDto;
import com.blogingsystem.blogingsystemapi.payload.PostResponse;
import com.blogingsystem.blogingsystemapi.service.PostService;
import com.blogingsystem.blogingsystemapi.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private final PostService postService;

    // Constructor-based dependency injection for PostService
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Endpoint to create a new blog post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        // Create the post and return it along with HTTP status CREATED
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // Endpoint to retrieve all posts with pagination and sorting
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_PAGE_DIRECTION, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    // Endpoint to retrieve a post by its ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        // Retrieve the post by its ID and return it along with HTTP status OK
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // Endpoint to update a post by its ID
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        // Update the post and return it along with HTTP status OK
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // Endpoint to delete a post by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        // Delete the post and return a success message along with HTTP status OK
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
}

