package com.githiomi.inkvibe.services;

import com.githiomi.inkvibe.data.models.Blog;

import java.util.List;
import java.util.UUID;

public interface BlogService {

    Blog saveBlog(Blog blog);

    void saveAllBlogs(List<Blog> blogs);

    List<Blog> getAllBlogs();

    Blog getBlogById(UUID id);

    Blog updateBlogById(UUID id, Blog blog);

    void deleteBlogById(UUID id);

    void deleteAllBlogs();
}
