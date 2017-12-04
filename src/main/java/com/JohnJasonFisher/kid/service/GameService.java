package com.JohnJasonFisher.kid.service;

import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    // needs logic if title is null
    public List<Game> searchGamesByTitle(String title) {
        String formattedTitle = "%" + title + "%";
        List<Game> results = gameRepo.findGamesByTitle(formattedTitle);
        return results;
    }

    public Game insertGame(Game game) throws Exception {
        if (game == null) {
            throw new Exception("Invalid input!");
        }

        Game insertedGame = gameRepo.save(game);
        return insertedGame;
    }

}
