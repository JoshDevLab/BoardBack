package com.josh.BoardBack.api;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.dto.BoardDto;
import com.josh.BoardBack.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("registerBoard")
    public ResponseEntity<Board> registerBoard(@RequestBody BoardDto boardDto) {

        return ResponseEntity.ok(boardService.registerBoard(boardDto));
    }
}
