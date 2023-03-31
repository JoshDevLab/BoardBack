package com.josh.BoardBack.repo;

import com.josh.BoardBack.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepo extends JpaRepository<Board, Long>, BoardRepoCustom {
}