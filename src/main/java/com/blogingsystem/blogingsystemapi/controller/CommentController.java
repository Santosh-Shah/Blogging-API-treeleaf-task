package com.blogingsystem.blogingsystemapi.controller;

import com.blogingsystem.blogingsystemapi.payload.CommentDto;
import com.blogingsystem.blogingsystemapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private final CommentService commentService;

    // Constructor-based dependency injection for CommentService
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Endpoint to create a new comment for a specific post
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @PathVariable(value = "postId") long postId,
            @RequestBody CommentDto commentDto) {

        // Create the comment and return it along with HTTP status CREATED
        return new ResponseEntity<>(commentService.createComment(postId, commentDto),
                HttpStatus.CREATED);
    }

    // Endpoint to retrieve all comments for a specific post
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(
            @PathVariable(value = "postId") Long postId) {

        // Return the list of comments for the specified post
        return commentService.getCommentByPostId(postId);
    }

    // Endpoint to retrieve a specific comment by its ID for a specific post
    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "id") Long commentId) {

        // Retrieve the comment by its ID and return it along with HTTP status OK
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    // Endpoint to update an existing comment for a specific post
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "id") Long commentId,
            @RequestBody CommentDto commentDto) {

        // Update the comment and return it along with HTTP status OK
        CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    // Endpoint to delete a specific comment by its ID for a specific post
    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "id") Long commentId) {

        // Delete the comment and return a success message along with HTTP status OK
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment has been deleted", HttpStatus.OK);
    }
}

