package com.githiomi.inkvibe.services.implementations;

import com.githiomi.inkvibe.data.records.Blog;
import com.githiomi.inkvibe.repositories.BlogRepository;
import com.githiomi.inkvibe.services.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void saveBlog(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void saveAllBlogs(List<Blog> blogs) {
        this.blogRepository.saveAll(blogs);
    }
}
