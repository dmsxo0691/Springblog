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
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        boardService.write(board, principalDetail.getUser());

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable Long id){
        boardService.deleteWrite(id);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable Long id, @RequestBody Board board){
        System.out.println("BoardApiController : update : id : "+id);
        System.out.println("BoardApiController : update : board : "+board.getTitle());
        System.out.println("BoardApiController : update : board : "+board.getContent());
        boardService.updateWrite(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
