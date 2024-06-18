package com.example.blogpost.service;

import com.example.blogpost.exception.DataNotFoundException;
import com.example.blogpost.helper.BlogDatabaseHelper;
import com.example.blogpost.response.BlogCommentResponse;
import com.example.blogpost.response.BlogResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    public List<BlogCommentResponse> getAllComments() {

        return BlogDatabaseHelper.getAllComments().stream()
                .map(comment->new BlogCommentResponse(comment.getId(), comment.getContent(), comment.getUpdatedAt()))
                .toList();

    }
    public List<BlogCommentResponse> getCommentsByBlogId(long id) {
        return BlogDatabaseHelper.getAllComments().stream()
                .filter(comment -> comment.getBlog().getId() == id)
                .map(comment->new BlogCommentResponse(comment.getId(), comment.getContent(), comment.getUpdatedAt()))
                .toList();
    }
    public List<BlogCommentResponse> getCommentsByUser(long id) {
        return BlogDatabaseHelper.getAllComments().stream()
                .filter(comment -> comment.getUser().getId() == id)
                .map(comment->new BlogCommentResponse(comment.getId(), comment.getContent(), comment.getUpdatedAt()))
                .toList();
    }
}
