package com.githiomi.inkvibe.services.implementations;

import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.exceptions.ApiException;
import com.githiomi.inkvibe.repositories.BlogRepository;
import com.githiomi.inkvibe.services.BlogService;
import com.githiomi.inkvibe.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final UserService userService;

    public BlogServiceImpl(BlogRepository blogRepository, UserService userService) {
        this.userService = userService;
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        blog.setLikeCounter(0);
        blog.setCreatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    @Override
    public void saveAllBlogs(List<Blog> blogs) {
        this.blogRepository.saveAll(blogs);
    }

    @Override
    public List<Blog> getBlogsByUsername(String username) {

        if (this.userService.findUserByUsername(username) == null) throw new ApiException("No user with username: {" + username + "} was found in the database.");
        return this.blogRepository.findBlogsByUsername(username);

    }

    @Override
    public List<Blog> getAllBlogs() {
        return this.blogRepository.findAll().reversed();
    }

    @Override
    public Blog getBlogById(UUID id) throws ApiException {
        return this.blogRepository.findById(id).orElseThrow(() -> new ApiException("Blog with ID: {" + id + "} was not found in the database."));
    }

    @Override
    public Blog updateBlogById(UUID id, Blog blog) throws ApiException {
        // First check if the blog with id exists
        Blog foundBlog = getBlogById(id);

        foundBlog.setId(id);
        foundBlog.setTitle(blog.getTitle());
        foundBlog.setAuthor(blog.getAuthor());
        foundBlog.setCategory(blog.getCategory());
        foundBlog.setCreatedAt(blog.getCreatedAt());
        foundBlog.setLikeCounter(blog.getLikeCounter());
        foundBlog.setLastUpdatedAt(LocalDateTime.now());

        return this.blogRepository.save(foundBlog);
    }

    @Override
    public void deleteBlogById(UUID id) {
        if (this.blogRepository.findById(id).isEmpty())
            throw new ApiException("Delete Unsuccessful. Blog with ID: {" + id + "} was not found in the database.");

        this.blogRepository.deleteById(id);
    }

    @Override
    public void deleteAllBlogs() {
        this.blogRepository.deleteAll();
    }
}
