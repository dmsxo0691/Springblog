package com.blog.SpringBootblog.repository;

import com.blog.SpringBootblog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
