package com.blog.SpringBootblog.repository;

import com.blog.SpringBootblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsernameAndPassword(String username, String password);
}
