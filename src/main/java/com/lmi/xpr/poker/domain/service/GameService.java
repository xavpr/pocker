package com.lmi.xpr.poker.domain.service;

import com.lmi.xpr.poker.domain.model.Game;

public interface GameService {
    Game createGame();
    boolean existsById(Long idGame);
    Game addPlayerToGame(Long idGame, Long idPlayer);
    Game removePlayerFromGame(Long idGame, Long idPlayer);
    Game addDeckToGame(Long idGame, Long idDeck);
}
