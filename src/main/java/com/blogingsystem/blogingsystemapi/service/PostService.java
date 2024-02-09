package com.blogingsystem.blogingsystemapi.service;

import com.blogingsystem.blogingsystemapi.payload.PostDto;
import com.blogingsystem.blogingsystemapi.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
