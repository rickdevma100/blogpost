package com.example.blogpost.controller;

import com.example.blogpost.response.BlogCommentResponse;
import com.example.blogpost.response.BlogResponse;
import com.example.blogpost.service.BlogService;
import com.example.blogpost.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/")
    public ResponseEntity<List<BlogCommentResponse>> getComments(){

        List<BlogCommentResponse> response =
                commentService.getAllComments();
        return new ResponseEntity<List<BlogCommentResponse>>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<BlogCommentResponse>> getCommentsbyBlogsById(@PathVariable long id){

        List<BlogCommentResponse> response =
                commentService.getCommentsByBlogId(id);
        return new ResponseEntity<List<BlogCommentResponse>>(response, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<BlogCommentResponse>> getBlogsByUser(@PathVariable long id){

        List<BlogCommentResponse> response =
                commentService.getCommentsByUser(id);
        return new ResponseEntity<List<BlogCommentResponse>>(response, HttpStatus.OK);
    }
}
