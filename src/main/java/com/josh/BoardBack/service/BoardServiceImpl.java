package com.josh.BoardBack.service;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.dto.BoardDto;
import com.josh.BoardBack.repo.BoardRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardRepo boardRepo;

    @Override
    public Board registerBoard(BoardDto boardDto) {
        return boardRepo.save(boardDto.toEntity());
    }

    @Override
    public List<Board> getBoards() {
        return boardRepo.findAll();
    }
}
