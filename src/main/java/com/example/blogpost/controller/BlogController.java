package com.example.blogpost.controller;

import com.example.blogpost.response.BlogResponse;
import com.example.blogpost.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/")
    public ResponseEntity<List<BlogResponse>> getBlogs(){

        List<BlogResponse> response =
                blogService.getAllBlogs();
        return new ResponseEntity<List<BlogResponse>>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BlogResponse> getBlogsById(@PathVariable long id){

        BlogResponse response =
                blogService.getBlogById(id);
        return new ResponseEntity<BlogResponse>(response, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<BlogResponse>> getBlogsByUser(@PathVariable long id){

        List<BlogResponse> response =
                blogService.getBlogByUser(id);
        return new ResponseEntity<List<BlogResponse>>(response, HttpStatus.OK);
    }
}
