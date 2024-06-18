package com.example.blogpost.helper;

import com.example.blogpost.domain.Blog;
import com.example.blogpost.domain.Comment;
import com.example.blogpost.domain.User;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class BlogDatabaseHelper {
    public static List<User> getAllUsers() {

        User user1 = User.builder().id(100).name("Rickdev").build();
        User user2 = User.builder().id(101).name("Sayantika").build();
        return Arrays.asList(user1,user2);

    }

    public static List<Blog> getAllBlogs() {
        Blog blog1 = Blog.builder()
                .id(101)
                .title("First Blog")
                .content("First Blog jsbdkjf skjdfksd")
                .createdAt(new Date(2023))
                .updatedAt(new Date(2023))
                .user(getAllUsers().get(0)).build();

        Blog blog2 = Blog.builder()
                .id(102)
                .title("Second Blog")
                .content("First Blog jsbdkjf skjdfksd")
                .createdAt(new Date(2023))
                .updatedAt(new Date(2023))
                .user(getAllUsers().get(1)).build();

        Blog blog3 = Blog.builder()
                .id(103)
                .title("Third Blog")
                .content("First Blog jsbdkjf skjdfksd")
                .createdAt(new Date(2023))
                .updatedAt(new Date(2023))
                .user(getAllUsers().get(0)).build();

        return Arrays.asList(blog1, blog2, blog3);

    }

    public static List<Comment> getAllComments() {
        Comment comment1 = Comment.builder()
                .id(101)
                .content("First Comment")
                .blog(getAllBlogs().get(0))
                .createdAt(new Date(2024))
                .updatedAt(new Date(2024))
                .user(getAllUsers().get(0)).build();

        Comment comment2 = Comment.builder()
                .id(102)
                .content("2nd Comment")
                .blog(getAllBlogs().get(1))
                .createdAt(new Date(2023))
                .updatedAt(new Date(2023))
                .user(getAllUsers().get(1)).build();

        Comment comment3 = Comment.builder()
                .id(103)
                .content("3rd Comment")
                .blog(getAllBlogs().get(0))
                .createdAt(new Date(2023))
                .updatedAt(new Date(2023))
                .user(getAllUsers().get(0)).build();

        return Arrays.asList(comment1,comment2,comment3);
    }
}
