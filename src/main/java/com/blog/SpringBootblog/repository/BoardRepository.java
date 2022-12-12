package com.blog.SpringBootblog.repository;

import com.blog.SpringBootblog.model.Board;
import com.blog.SpringBootblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long>{
}
