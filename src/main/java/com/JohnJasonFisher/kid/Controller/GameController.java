package com.JohnJasonFisher.kid.Controller;

import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// I want to do @RequestMapping("/api") to keep my code dry
// both /api/games is causing /game to still work
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public List<Game> searchGamesByTitle(@RequestParam(value = "title") String title) {
        List<Game> results = gameService.searchGamesByTitle(title);
        return results;
    }

    @GetMapping("/notes/{id}")
    public Game searchGameById(@PathVariable(value="id") Long id) {
        Game result = gameService.searchGameById(id);
        return result;
        // which one is better?
//        if (result == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/games/all")
    public List<Game> searchAllGames() {
        List<Game> results = gameService.searchAllGames();
        return results;
    }

    @PostMapping("/games")
    // maybe @Valid instead of final? idk
    public Game createdGame(@RequestBody final Game game) throws Exception {
        Game created = gameService.insertGame(game);
        return created;
    }

    // put game

    // delete game
}
