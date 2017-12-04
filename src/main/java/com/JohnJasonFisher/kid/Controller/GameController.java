package com.JohnJasonFisher.kid.Controller;

import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
