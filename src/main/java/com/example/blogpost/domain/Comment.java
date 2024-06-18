package com.example.blogpost.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Entity
@Data
@Builder
@Table(name = "Comment")
public class Comment {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
	private User user;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy/mm/dd")
    private Date createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy/mm/dd")
    private Date updatedAt;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_id")
	private Blog blog;

}
