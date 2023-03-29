package com.josh.BoardBack.dto;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.board.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {
    private Long id;

    private String content;

    private Board board;

    private Comment parentComment;
}
