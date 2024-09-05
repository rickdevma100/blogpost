package com.example.blogpost.repository;

import com.example.blogpost.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
public interface BlogRepository extends JpaRepository<Blog,Long> {

}
