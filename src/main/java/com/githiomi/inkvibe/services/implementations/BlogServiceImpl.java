package com.githiomi.inkvibe.services.implementations;

import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.exceptions.BlogException;
import com.githiomi.inkvibe.repositories.BlogRepository;
import com.githiomi.inkvibe.services.BlogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    @Override
    public void saveAllBlogs(List<Blog> blogs) {
        this.blogRepository.saveAll(blogs);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return this.blogRepository.findAll().reversed();
    }

    @Override
    public Blog getBlogById(UUID id) throws BlogException {
        return this.blogRepository.findById(id).orElseThrow( () -> new BlogException("Blog with ID: {" + id +"} does not exist."));
    }

    @Override
    public Blog updateBlogById(UUID id, Blog blog) throws BlogException{
        // First check if the blog with id exists
        Blog foundBlog = getBlogById(id);

        foundBlog.setId(id);
        foundBlog.setTitle(blog.getTitle());
        foundBlog.setCategory(blog.getCategory());
        foundBlog.setCreatedAt(blog.getCreatedAt());
        foundBlog.setLastUpdatedAt(LocalDateTime.now());

        return this.blogRepository.save(foundBlog);
    }

    @Override
    public void deleteBlogById(UUID id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public void deleteAllBlogs() {
        this.blogRepository.deleteAll();
    }
}
