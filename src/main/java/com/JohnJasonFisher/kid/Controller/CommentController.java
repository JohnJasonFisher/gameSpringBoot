package com.JohnJasonFisher.kid.Controller;

import com.JohnJasonFisher.kid.entity.Comment;
import com.JohnJasonFisher.kid.repository.CommentRepository;
import com.JohnJasonFisher.kid.repository.GameRepository;
import com.JohnJasonFisher.kid.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // add exception when gameId cannot be found or there are no comments
    @GetMapping("/games/{gameId}/comments")
    public List<Comment> searchCommentsByGameId(@PathVariable("gameId") Long gameId) throws Exception {
        List<Comment> gameComments = commentService.searchCommentsByGameId(gameId);
        return gameComments;
    }

    @PostMapping("/games/{gameId}/comments")
    public Comment createNewGameComment(@PathVariable("gameId") Long gameId,@RequestBody final Comment comment) throws Exception {
        Comment created = commentService.createGameComment(comment, gameId);
        return created;
    }
}
