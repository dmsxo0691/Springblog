package com.blog.SpringBootblog.Controller.api;

import com.blog.SpringBootblog.config.auth.PrincipalDetail;
import com.blog.SpringBootblog.dto.ResponseDto;
import com.blog.SpringBootblog.model.Board;
import com.blog.SpringBootblog.model.User;
import com.blog.SpringBootblog.service.BoardService;
import com.blog.SpringBootblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        boardService.write(board, principalDetail.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
