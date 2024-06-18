package com.example.blogpost.service;

import com.example.blogpost.exception.DataNotFoundException;
import com.example.blogpost.helper.BlogDatabaseHelper;
import com.example.blogpost.response.BlogResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    public List<BlogResponse> getAllBlogs() {

        return BlogDatabaseHelper.getAllBlogs().stream()
                .map(blog->new BlogResponse(blog.getId(), blog.getTitle(), blog.getContent(), blog.getUpdatedAt()))
                .toList();

    }
    public BlogResponse getBlogById(long id) {
        return BlogDatabaseHelper.getAllBlogs().stream()
                .filter(blog -> blog.getId() == id)
                .map(blog->new BlogResponse(blog.getId(), blog.getTitle(), blog.getContent(), blog.getUpdatedAt()))
                .findFirst().orElseThrow(()->new DataNotFoundException("No Value Found"));
    }
    public List<BlogResponse> getBlogByUser(long id) {
        return BlogDatabaseHelper.getAllBlogs().stream()
                .filter(blog -> blog.getUser().getId() == id)
                .map(blog->new BlogResponse(blog.getId(), blog.getTitle(), blog.getContent(), blog.getUpdatedAt()))
                .toList();
    }
}
