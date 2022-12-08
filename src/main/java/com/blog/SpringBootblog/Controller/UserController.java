package com.blog.SpringBootblog.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/user/joinForm")
    public String joinForm(){

        return "user/joinForm";
    }
}
