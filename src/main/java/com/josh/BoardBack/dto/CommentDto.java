package com.josh.BoardBack.dto;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.board.Comment;
import com.josh.BoardBack.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CommentDto {
    private Long id;

    private String content;

    private Board board;

    private Comment parentComment;

    private List<Comment> childComments;

    private User user;

    public Comment toEntity() {
        return Comment.builder()
                .id(id)
                .content(content)
                .board(board)
                .user(user)
                .parentComment(parentComment)
                .childComments(childComments)
                .build();
    }
}
