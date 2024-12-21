package com.githiomi.inkvibe.services;

import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.exceptions.BlogException;

import java.util.List;
import java.util.UUID;

public interface BlogService {

    Blog saveBlog(Blog blog);

    void saveAllBlogs(List<Blog> blogs);

    List<Blog> getAllBlogs();

    Blog getBlogById(UUID id) throws BlogException;

    Blog updateBlogById(UUID id, Blog blog) throws BlogException;

    void deleteBlogById(UUID id);

    void deleteAllBlogs();
}
