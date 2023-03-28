package com.josh.BoardBack.service;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.dto.BoardDto;

public interface BoardService {
    Board registerBoard(BoardDto boardDto);
}
