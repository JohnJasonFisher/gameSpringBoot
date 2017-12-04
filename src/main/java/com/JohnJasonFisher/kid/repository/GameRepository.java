package com.JohnJasonFisher.kid.repository;

import com.JohnJasonFisher.kid.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT g FROM Game g WHERE lower(g.title) LIKE lower(?1)")
    public List<Game> findGamesByTitle(String title);
}
