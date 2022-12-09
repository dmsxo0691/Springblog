package com.blog.SpringBootblog.Controller.api;

import com.blog.SpringBootblog.dto.ResponseDto;
import com.blog.SpringBootblog.model.RoleType;
import com.blog.SpringBootblog.model.User;
import com.blog.SpringBootblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
