package com.example.blogpost.response;


import java.sql.Date;

public record BlogResponse(long id, String title, String content, Date updatedAt) {
}
