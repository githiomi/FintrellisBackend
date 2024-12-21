package com.githiomi.inkvibe.controller;

import com.githiomi.inkvibe.data.enums.ResponseType;
import com.githiomi.inkvibe.data.models.ApiResponse;
import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.exceptions.BlogException;
import com.githiomi.inkvibe.services.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.githiomi.inkvibe.data.enums.ResponseType.DATA_RESPONSE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Blog>>> getAllBlogs() {
        ApiResponse<List<Blog>> response = new ApiResponse<>(this.blogService.getAllBlogs(), DATA_RESPONSE);
        return new ResponseEntity<>(response, OK);
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<ApiResponse<Blog>> getBlogById(@PathVariable("blogId") UUID id) throws BlogException {
        ApiResponse<Blog> response = new ApiResponse<>(this.blogService.getBlogById(id), DATA_RESPONSE);
        return new ResponseEntity<>(response, OK);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Blog>> createBlog(@RequestBody Blog blog) {
        ApiResponse<Blog> response = new ApiResponse<>(this.blogService.saveBlog(blog), DATA_RESPONSE);
        return new ResponseEntity<>(response, CREATED);
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<ApiResponse<Blog>> updateBlog(@PathVariable("blogId") UUID id, @RequestBody Blog blog) throws BlogException {
        ApiResponse<Blog> response = new ApiResponse<>(this.blogService.updateBlogById(id, blog), DATA_RESPONSE);
        return ResponseEntity.status(OK).body(response);
    }

    @DeleteMapping("")
    public ResponseEntity<ApiResponse<String>> deleteAllBlogs() {
        this.blogService.deleteAllBlogs();
        return ResponseEntity.status(OK).body(new ApiResponse<>("All Blogs have been deleted successfully", DATA_RESPONSE));
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<ApiResponse<String>> deleteBlog(@PathVariable("blogId") UUID id) {
        this.blogService.deleteBlogById(id);
        return ResponseEntity.status(OK).body(new ApiResponse<>("Blog with id: {" + id + "} has been deleted", DATA_RESPONSE));
    }

}
