package com.example.blogpost.response;


import java.sql.Date;

public record BlogCommentResponse(long id, String content, Date updatedAt) {
}
