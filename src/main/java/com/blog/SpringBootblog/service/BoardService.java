package com.blog.SpringBootblog.service;

;
import com.blog.SpringBootblog.model.Board;
import com.blog.SpringBootblog.model.Reply;
import com.blog.SpringBootblog.model.User;
import com.blog.SpringBootblog.repository.BoardRepository;
import com.blog.SpringBootblog.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;


    @Transactional
    public void write(Board board, User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> writeList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board showWrite(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("상세 보기 실패: 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void deleteWrite(Long id) {
        System.out.println("글 삭제" + id);
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updateWrite(Long id, Board requestBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
    }

    @Transactional
    public void writeReply(User user, Long boardId, Reply requestReply) {
        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            return new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없습니다.");
        }); // 영속화 완료;

        requestReply.setUser(user);
        requestReply.setBoard(board);

        replyRepository.save(requestReply);
    }

    @Transactional
    public void deleteReply(Long replyId) {
        replyRepository.deleteById(replyId);
    }
}
