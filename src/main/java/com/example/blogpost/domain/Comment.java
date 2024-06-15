package com.example.blogpost.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "Comment")
public class Comment {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String content;
	private String author;

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
