package com.JohnJasonFisher.kid.repository;

import com.JohnJasonFisher.kid.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    // This if you just want to do straight up sql
    // @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)

    @Query("SELECT g FROM Game g WHERE lower(g.title) LIKE lower(?1)")
    public List<Game> findGamesByTitle(String title);
}
