package com.josh.BoardBack.dto;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardDto {
    private Long id;

    private String title;

    private String content;

    private User author;

    public Board toEntity() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
