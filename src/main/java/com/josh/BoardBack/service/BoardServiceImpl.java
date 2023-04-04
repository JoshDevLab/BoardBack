package com.josh.BoardBack.service;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.config.CustomTuple;
import com.josh.BoardBack.config.JwtService;
import com.josh.BoardBack.dto.BoardDto;
import com.josh.BoardBack.repo.BoardRepo;
import com.josh.BoardBack.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardRepo boardRepo;

    private final UserDetailsService userDetailsService;

    @Override
    public Board registerBoard(BoardDto boardDto) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName(); // SecurityContextHolder 에 있는 인증정보를 가져옴
        boardDto.setAuthor((User) userDetailsService.loadUserByUsername(userEmail));
        return boardRepo.save(boardDto.toEntity());
    }

    @Override
    public List<CustomTuple> getBoards() {
        return boardRepo.customFindAll();
    }
}
