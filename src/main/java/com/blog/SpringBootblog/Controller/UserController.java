package com.blog.SpringBootblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    // 인증 안된 사용자들 /auth 경로만 허용
    // 주소가 / 일 경우 index 허용
    // static 이하 주소 허용
    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }
}
