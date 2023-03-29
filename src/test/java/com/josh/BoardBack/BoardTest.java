package com.josh.BoardBack;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.dto.BoardDto;
import com.josh.BoardBack.repo.BoardRepo;
import com.josh.BoardBack.service.BoardService;
import com.josh.BoardBack.user.User;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class BoardTest {

    @Autowired
    private BoardService service;

    @Autowired
    private BoardRepo repo;

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

//        BoardDto boardDto2 = BoardDto.builder()
//                .title("테스트제목2")
//                .content("테스트내용2")
//                .author(user).build();
//
//        BoardDto boardDto3 = BoardDto.builder()
//                .title("테스트제목3")
//                .content("테스트내용3")
//                .author(user).build();

        // when
        service.registerBoard(boardDto);
//        service.registerBoard(boardDto2);
//        service.registerBoard(boardDto3);

        // then
        Assertions.assertThat(service.getBoards().size()).isEqualTo(2);
    }

}