package com.JohnJasonFisher.kid.service;

import com.JohnJasonFisher.kid.entity.Game;
import com.JohnJasonFisher.kid.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    public Game searchGameById(Long id) {
        Game result = gameRepo.getOne(id);
        return result;
    }

    // needs logic if title is null
    public List<Game> searchGamesByTitle(String title) {
        String formattedTitle = "%" + title + "%";
        List<Game> results = gameRepo.findGamesByTitle(formattedTitle);
        return results;
    }

    public List<Game> searchAllGames() {
        List<Game> results = gameRepo.findAll();
        return results;
    }

    public Game insertGame(Game game) throws Exception {
        if (game == null) {
            throw new Exception("Invalid input!");
        }

        Game insertedGame = gameRepo.save(game);
        return insertedGame;
    }

    public void updateGameById(
            Long id,
            Game gameDetails
    ) {
        Game updateGame = gameRepo.getOne(id);
        updateGame.setTitle(gameDetails.getTitle());
        updateGame.setDescription(gameDetails.getDescription());
        updateGame.setRelease_date(gameDetails.getRelease_date());
        gameRepo.save(updateGame);
    }

}
