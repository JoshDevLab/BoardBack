package com.josh.BoardBack.repo;

import com.josh.BoardBack.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
