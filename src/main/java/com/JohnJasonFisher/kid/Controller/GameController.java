package com.JohnJasonFisher.kid.Controller;

import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public List<Game> searchGamesByTitle(@RequestParam(value = "title", required = true) String title) {
        List<Game> results = gameService.searchGamesByTitle(title);
        return results;
    }

    @PostMapping("/games")
    // maybe @Valid instead of final? idk
    public Game createdGame(@RequestBody final Game game) throws Exception {
        Game created = gameService.insertGame(game);
        return created;
    }
}
