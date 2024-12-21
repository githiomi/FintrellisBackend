package com.githiomi.inkvibe.services;

import com.githiomi.inkvibe.data.records.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {

    void saveBlog(Blog blog);

    void saveAllBlogs(List<Blog> blogs);
}
