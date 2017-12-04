package com.JohnJasonFisher.kid.service;

import com.JohnJasonFisher.kid.entity.Comment;
import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.repository.CommentRepository;
import com.JohnJasonFisher.kid.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private GameRepository gameRepo;

    public List<Comment> searchCommentsByGameId(Long gameId) throws Exception {
        if (null == gameId) {
            throw new Exception("Invalid game id.");
        }

        List<Comment> results = commentRepo.findCommentsByGameId(gameId);
        return results;
    }

    // creates comment about game
    public Comment createGameComment(Comment comment, Long gameId) throws Exception {
        if (null == comment || null == gameId) {
            throw new Exception("Invalid Parameters.");
        }

        Game game = gameRepo.findOne(gameId); // findOne() is from JPA I think
        if (null == game) {
            throw new Exception("Cannot find game with id=" + gameId);
        }

        comment.setGame(game); // From Comment entity because manyToOne relationship

        Comment created = commentRepo.save(comment);
        return created;
    }
}
