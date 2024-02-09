package com.blogingsystem.blogingsystemapi.repository;

import com.blogingsystem.blogingsystemapi.entity.Comment;
import com.blogingsystem.blogingsystemapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
}
