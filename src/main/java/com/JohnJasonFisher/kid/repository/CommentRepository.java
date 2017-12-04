package com.JohnJasonFisher.kid.repository;

import com.JohnJasonFisher.kid.entity.Comment;
import com.JohnJasonFisher.kid.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.game.id = ?1")
    public List<Comment> findCommentsByGameId(Long gameId);
}
