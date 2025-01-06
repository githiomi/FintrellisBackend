package com.githiomi.inkvibe.controller;

import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.data.models.RestResponse;
import com.githiomi.inkvibe.exceptions.ApiException;
import com.githiomi.inkvibe.services.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.githiomi.inkvibe.data.enums.ResponseType.DATA_RESPONSE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("api/v1/blog")
@Tag(name = "Blog", description = "CRUD operations for Blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    @Operation(summary = "List all Blogs", description = "Get a list of all the blogs")
    public ResponseEntity<RestResponse<List<Blog>>> getAllBlogs() {
        RestResponse<List<Blog>> response = new RestResponse<>(this.blogService.getAllBlogs(), DATA_RESPONSE);
        return new ResponseEntity<>(response, OK);
    }

    @GetMapping("/{blogId}")
    @Operation(summary = "Get a blog", description = "Get a specific blog from the database by its ID")
    public ResponseEntity<RestResponse<Blog>> getBlogById(@PathVariable("blogId") UUID id) throws ApiException {
        RestResponse<Blog> response = new RestResponse<>(this.blogService.getBlogById(id), DATA_RESPONSE);
        return new ResponseEntity<>(response, OK);
    }

    @GetMapping("/user")
    @Operation(summary = "Get blogs from a user", description = "Get a list of blogs from a specific user")
    public ResponseEntity<RestResponse<List<Blog>>> getBlogsByUsername(@RequestParam("username") String username) {
        RestResponse<List<Blog>> response = new RestResponse<>(this.blogService.getBlogsByUsername(username.toUpperCase()), DATA_RESPONSE);
        return new ResponseEntity<>(response, OK);
    }

    @PostMapping("")
    @Operation(summary = "Create a blog", description = "Create a new blog and add it to the database")
    public ResponseEntity<RestResponse<Blog>> createBlog(@RequestBody Blog blog) {
        RestResponse<Blog> response = new RestResponse<>(this.blogService.saveBlog(blog), DATA_RESPONSE);
        return new ResponseEntity<>(response, CREATED);
    }

    @PutMapping("/{blogId}")
    @Operation(summary = "Update a blog", description = "Update the contents of a specific blog")
    public ResponseEntity<RestResponse<Blog>> updateBlog(@PathVariable("blogId") UUID id, @RequestBody Blog blog) throws ApiException {
        RestResponse<Blog> response = new RestResponse<>(this.blogService.updateBlogById(id, blog), DATA_RESPONSE);
        return ResponseEntity.status(OK).body(response);
    }

    @DeleteMapping("")
    @Operation(summary = "Delete all Blogs", description = "Delete all the blog posts in the database")
    public ResponseEntity<RestResponse<String>> deleteAllBlogs() {
        this.blogService.deleteAllBlogs();
        return ResponseEntity.status(OK).body(new RestResponse<>("All Blogs have been deleted successfully", DATA_RESPONSE));
    }

    @DeleteMapping("/{blogId}")
    @Operation(summary = "Delete a blog", description = "Delete a blog from the database using its ID")
    public ResponseEntity<RestResponse<String>> deleteBlog(@PathVariable("blogId") UUID id) {
        this.blogService.deleteBlogById(id);
        return ResponseEntity.status(OK).body(new RestResponse<>("Blog with id: {" + id + "} was deleted successfully.", DATA_RESPONSE));
    }

}
