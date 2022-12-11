package com.blog.SpringBootblog.repository;

import com.blog.SpringBootblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    //SELECT * FROM user WHERE username = 1?
    Optional<User> findByUsername(String username);
}
