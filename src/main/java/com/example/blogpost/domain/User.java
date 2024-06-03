package com.example.blogpost.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
}
