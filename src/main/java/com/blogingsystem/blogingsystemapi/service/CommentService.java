package com.blogingsystem.blogingsystemapi.service;

import com.blogingsystem.blogingsystemapi.payload.CommentDto;

import java.util.List;

public interface CommentService {

    // Create a new comment for a specific post
    CommentDto createComment(long postId, CommentDto commentDto);

    // Get all comments for a specific post
    List<CommentDto> getCommentByPostId(long postId);

    // Get a specific comment by its ID within a post
    CommentDto getCommentById(long postId, long commentId);

    // Update a comment within a post
    CommentDto updateComment(long postId, long commentId, CommentDto commentRequest);

    // Delete a comment within a post
    void deleteComment(long postId, long commentId);
}

