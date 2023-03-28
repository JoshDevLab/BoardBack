package com.josh.BoardBack.service;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.dto.BoardDto;

import java.util.List;

public interface BoardService {
    Board registerBoard(BoardDto boardDto);

    List<Board> getBoards();
}
