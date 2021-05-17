package com.lmi.xpr.poker.domain.service;

import com.lmi.xpr.poker.domain.model.Card;
import com.lmi.xpr.poker.domain.model.Game;
import com.lmi.xpr.poker.domain.model.GameDeckStatus;
import com.lmi.xpr.poker.domain.model.Score;

import java.util.List;

public interface GameService {
    Game createGame();
    boolean existsById(Long idGame);
    Game addPlayerToGame(Long idGame, Long idPlayer);
    Game removePlayerFromGame(Long idGame, Long idPlayer);
    Game addDeckToGame(Long idGame, Long idDeck);
    void dealCard(Long idGame, Long idPlayer);
    List<Score> getScore(Long idGame);
    void shuffle(Long idGame);
    List<Card> getPlayerHandGame(Long idGame, Long idPlayer);
    GameDeckStatus getGameDeckStatus(Long idGame);
}
