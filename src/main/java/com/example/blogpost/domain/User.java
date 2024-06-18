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

    @Column(name="Name")
    private String name;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Blog> blogs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
