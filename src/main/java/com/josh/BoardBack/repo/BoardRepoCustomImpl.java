package com.josh.BoardBack.repo;

import com.josh.BoardBack.board.Board;
import com.josh.BoardBack.board.QBoard;
import com.josh.BoardBack.board.QComment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepoCustomImpl implements BoardRepoCustom{

    private final JPAQueryFactory query;

    QBoard board = QBoard.board;
    QComment comment = QComment.comment;

    @Override
    public List<Board> findAll() {
        return query.select(board)
                .from(board)
                .leftJoin(board.comments, comment)
                .groupBy(board.id)
                .orderBy(board.id.asc())
                .fetch();
    }
}
