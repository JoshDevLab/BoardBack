package com.josh.BoardBack.service;

import com.josh.BoardBack.board.Comment;
import com.josh.BoardBack.dto.CommentDto;
import com.josh.BoardBack.repo.CommentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepo commentRepo;

    @Override
    public Comment registerComment(CommentDto commentDto) {
        return commentRepo.save(commentDto.toEntity());
    }
}
