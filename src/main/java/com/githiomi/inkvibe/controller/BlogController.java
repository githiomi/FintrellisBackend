package com.githiomi.inkvibe.controller;

import com.githiomi.inkvibe.data.DTOs.BlogDTO;
import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.services.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return new ResponseEntity<>(this.blogService.getAllBlogs(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        Blog createdBlog = this.blogService.saveBlog(blog);
        return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
    }

}
