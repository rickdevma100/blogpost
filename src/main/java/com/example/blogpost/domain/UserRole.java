package com.example.blogpost.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "USER_ROLE")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
}
