package com.josh.BoardBack.board;

import com.josh.BoardBack.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> childComments; // List -> Set으로 변경

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
