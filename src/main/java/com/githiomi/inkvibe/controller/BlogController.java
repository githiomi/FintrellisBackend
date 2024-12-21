package com.githiomi.inkvibe.controller;

import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.services.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return new ResponseEntity<>(this.blogService.getAllBlogs(), OK);
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") UUID id) {
        return ResponseEntity.status(OK).body(this.blogService.getBlogById(id));
    }

    @PostMapping("")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(this.blogService.saveBlog(blog), HttpStatus.CREATED);
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("blogId") UUID id, @RequestBody Blog blog) {
        return ResponseEntity.status(OK).body(this.blogService.updateBlogById(id, blog));
    }

}
