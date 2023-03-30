package com.josh.BoardBack.service;

import com.josh.BoardBack.board.Comment;
import com.josh.BoardBack.dto.CommentDto;

public interface CommentService {

    Comment registerComment(CommentDto commentDto);
}
