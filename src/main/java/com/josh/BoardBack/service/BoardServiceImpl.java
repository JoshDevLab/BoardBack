package com.josh.BoardBack.service;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.dto.BoardDto;
import com.josh.BoardBack.repo.BoardRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepo boardRepo;

    @Override
    public Board registerBoard(BoardDto boardDto) {
        return boardRepo.save(boardDto.toEntity());
    }
}
