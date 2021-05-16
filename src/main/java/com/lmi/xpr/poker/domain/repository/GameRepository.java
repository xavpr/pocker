package com.lmi.xpr.poker.domain.repository;

import com.lmi.xpr.poker.domain.model.Game;

import java.util.Optional;

public interface GameRepository {
    Game createGame(Game game);
    boolean existsById(Long idGame);
    Optional<Game> getById(Long idGame);
    Game saveGame(Game game);
}
