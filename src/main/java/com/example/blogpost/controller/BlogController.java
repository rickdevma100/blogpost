package com.example.blogpost.controller;

import com.example.blogpost.domain.Blog;
import com.example.blogpost.response.BlogResponse;
import com.example.blogpost.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/")
    public ResponseEntity<List<Blog>> getBlogs(){

        List<Blog> response =
                blogService.getAllBlogs();
        return new ResponseEntity<List<Blog>>(response, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
        return new ResponseEntity<Blog>(blogService.saveBlogs(blog),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogsById(@PathVariable long id){
        return new ResponseEntity<Blog>(blogService.getAllBlogsById(id), HttpStatus.OK);
    }
//    @GetMapping("/user/{id}")
//    public ResponseEntity<List<BlogResponse>> getBlogsByUser(@PathVariable long id){
//
//        List<BlogResponse> response =
//                blogService.getBlogByUser(id);
//        return new ResponseEntity<List<BlogResponse>>(response, HttpStatus.OK);
//    }
}
