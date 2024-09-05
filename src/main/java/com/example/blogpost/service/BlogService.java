package com.example.blogpost.service;

import com.example.blogpost.domain.Blog;
import com.example.blogpost.exception.DataNotFoundException;
import com.example.blogpost.helper.BlogDatabaseHelper;
import com.example.blogpost.repository.BlogRepository;
import com.example.blogpost.response.BlogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Blog saveBlogs(Blog blog){
        return blogRepository.save(blog);

    }

    public Blog getAllBlogsById(long blogId) {
        return blogRepository.findById(blogId).get();
    }
    public List<Blog> getAllBlogs() {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 3);
        return blogRepository.findAll(firstPageWithTwoElements).getContent();

    }
//    public BlogResponse getBlogById(long id) {
//        return BlogDatabaseHelper.getAllBlogs().stream()
//                .filter(blog -> blog.getId() == id)
//                .map(blog->new BlogResponse(blog.getId(), blog.getTitle(), blog.getContent(), blog.getUpdatedAt()))
//                .findFirst().orElseThrow(()->new DataNotFoundException("No Value Found"));
//    }
//    public List<BlogResponse> getBlogByUser(long id) {
//        return BlogDatabaseHelper.getAllBlogs().stream()
//                .filter(blog -> blog.getUser().getId() == id)
//                .map(blog->new BlogResponse(blog.getId(), blog.getTitle(), blog.getContent(), blog.getUpdatedAt()))
//                .toList();
//    }
}
