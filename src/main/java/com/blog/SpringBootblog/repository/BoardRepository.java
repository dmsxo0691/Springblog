package com.blog.SpringBootblog.repository;

import com.blog.SpringBootblog.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long>{
}
