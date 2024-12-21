package com.githiomi.inkvibe.services;

import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.exceptions.ApiException;

import java.util.List;
import java.util.UUID;

public interface BlogService {

    Blog saveBlog(Blog blog);

    void saveAllBlogs(List<Blog> blogs);

    List<Blog> getAllBlogs();

    List<Blog> getBlogsByUsername(String username);

    Blog getBlogById(UUID id) throws ApiException;

    Blog updateBlogById(UUID id, Blog blog) throws ApiException;

    void deleteBlogById(UUID id);

    void deleteAllBlogs();

}
