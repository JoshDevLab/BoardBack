package com.josh.BoardBack.api;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.config.CustomTuple;
import com.josh.BoardBack.dto.BoardDto;
import com.josh.BoardBack.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Board> registerBoard(@RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(boardService.registerBoard(boardDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomTuple>> getBoards() {
        return ResponseEntity.ok(boardService.getBoards());
    }

}
