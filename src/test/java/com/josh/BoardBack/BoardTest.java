package com.josh.BoardBack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.board.Comment;
import com.josh.BoardBack.config.CustomTuple;
import com.josh.BoardBack.dto.BoardDto;
import com.josh.BoardBack.dto.CommentDto;
import com.josh.BoardBack.service.BoardService;
import com.josh.BoardBack.service.CommentService;
import com.josh.BoardBack.user.Role;
import com.josh.BoardBack.user.User;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class BoardTest {

    @Autowired
    private BoardService service;
    @Autowired
    private CommentService commentService;

    @Test
    @DisplayName("게시판 글등록 테스트")
    public void registerBoard() {
        // given
        User user = User.builder()
                .id(1L)
                .build();

        BoardDto boardDto = BoardDto.builder()
                .title("테스트제목")
                .content("테스트내용")
                .author(user).build();

        // when
        Board board = service.registerBoard(boardDto);

        // then
        Assertions.assertThat(board.getTitle()).isEqualTo(boardDto.getTitle());
        Assertions.assertThat(board.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("게시글 조회 테스트")
    public void getBoards() {
        // given
        User user = User.builder()
                .id(1L)
                .build();

        BoardDto boardDto = BoardDto.builder()
                .title("테스트제목")
                .content("테스트내용")
                .author(user).build();

        BoardDto boardDto2 = BoardDto.builder()
                .title("테스트제목2")
                .content("테스트내용2")
                .author(user).build();

        BoardDto boardDto3 = BoardDto.builder()
                .title("테스트제목3")
                .content("테스트내용3")
                .author(user).build();

        // when
        service.registerBoard(boardDto);
        service.registerBoard(boardDto2);
        service.registerBoard(boardDto3);

        // then
        Assertions.assertThat(service.getBoards().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("댓글쓰기 테스트")
    public void registerCommentTest() {
        // given
        User user = User.builder()
                .id(1L)
                .build();

        BoardDto boardDto = BoardDto.builder()
                .title("테스트제목")
                .content("테스트내용")
                .author(user).build();

        CommentDto commentDto = CommentDto.builder()
                .content("댓글내용")
                .board(boardDto.toEntity())
                .user(user).build();

        service.registerBoard(boardDto);

        // when
        Comment comment = commentService.registerComment(commentDto);

        // then
        Assertions.assertThat(comment.getContent()).isEqualTo("댓글내용");
    }


    @Test
    @DisplayName("대댓글쓰기 테스트")
    public void registerCoCommentTest() {
        // given
        User user = User.builder()
                .id(1L)
                .build();

        BoardDto boardDto = BoardDto.builder()
                .title("테스트제목")
                .content("테스트내용")
                .author(user).build();

        service.registerBoard(boardDto);

        CommentDto commentDto = CommentDto.builder()
                .content("댓글내용")
                .board(boardDto.toEntity())
                .user(user).build();

        CommentDto cocommentDto = CommentDto.builder()
                .content("대댓글내용")
                .parentComment(commentDto.toEntity())
                .user(user).build();

        // when
        Comment comment = commentService.registerComment(commentDto);
        Comment cocomment = commentService.registerComment(cocommentDto);

        // then
        Assertions.assertThat(comment.getId()).isEqualTo(1L);
        Assertions.assertThat(cocomment.getId()).isEqualTo(2L);
    }

    @Test
    @DisplayName("대댓글까지 조회 테스트")
    public void cocommentSelect() throws JsonProcessingException {

        // given
        User user = User.builder()
                .id(1L)
                .role(Role.USER)
                .build();

        BoardDto boardDto = BoardDto.builder()
                .title("테스트제목")
                .content("테스트내용")
                .author(user).build();

        Board board = service.registerBoard(boardDto);

        CommentDto commentDto = CommentDto.builder()
                .content("댓글내용")
                .board(board)
                .user(user).build();

        Comment comment = commentService.registerComment(commentDto);

        CommentDto cocommentDto = CommentDto.builder()
                .content("대댓글내용")
                .board(board)
                .parentComment(comment)
                .user(user).build();

        commentService.registerComment(cocommentDto);

        // when
        List<CustomTuple> boards = service.getBoards();

        // ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();

        String resultJson = objectMapper.writeValueAsString(boards);
        System.out.println("resultJson = " + resultJson);

        // then
        Assertions.assertThat(boards.size()).isEqualTo(1);
        //Assertions.assertThat(boards.get(0).getComments().size()).isEqualTo(2);
    }
}