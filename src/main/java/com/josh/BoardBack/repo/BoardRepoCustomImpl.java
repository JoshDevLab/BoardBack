package com.josh.BoardBack.repo;

import com.josh.BoardBack.board.QBoard;
import com.josh.BoardBack.board.QComment;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.josh.BoardBack.config.CustomTuple;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BoardRepoCustomImpl implements BoardRepoCustom{

    private final JPAQueryFactory query;

    QBoard board = QBoard.board;
    QComment comment = QComment.comment;
    QComment childComment = new QComment("childComment");

    @Override
    public List<CustomTuple> customFindAll() {
        List<Tuple> tuples = query
                .select(board, comment, childComment)
                .from(board)
                .leftJoin(board.comments, comment)
                .fetchJoin()
                .leftJoin(comment.childComments, childComment)
                .fetchJoin()
                .orderBy(board.id.asc(), comment.id.asc(), childComment.id.asc())
                .fetch();

        return tuples.stream()
                .map(CustomTuple::new)
                .collect(Collectors.toList());
    }
}
