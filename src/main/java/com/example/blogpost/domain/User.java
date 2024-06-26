package com.example.blogpost.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@Table(name = "User_Master")
public class User {
    @Id
    private long id;

    @Column(name="Email")
    private String emailId;

    @Column(name="User_name")
    private String username;

    @Column(name="Password")
    private String password;

    @Column(name="Status")
    private boolean status;

    @OneToOne
    @JoinColumn(name = "role_id")
    private UserRole role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Blog> blogs;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Comment> comments;
}
