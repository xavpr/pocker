package com.lmi.xpr.poker.domain.service.impl;

import com.lmi.xpr.poker.domain.model.Game;
import com.lmi.xpr.poker.domain.model.Player;
import com.lmi.xpr.poker.domain.repository.GameRepository;
import com.lmi.xpr.poker.domain.repository.PlayerRepository;
import com.lmi.xpr.poker.domain.service.GameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;


    @Override
    public Game createGame() {
        log.info("Creating new game");
        Game game = new Game();
        return gameRepository.createGame(game);
    }

    @Override
    public boolean existsById(Long idGame) {
        return gameRepository.existsById(idGame);
    }

    @Override
    public Game addPlayerToGame(Long idGame, Long idPlayer) {
        //At this level game and player should exist
        Game game = gameRepository.getById(idGame).get();
        Player player = playerRepository.getById(idPlayer).get();
        game.addPlayer(player);
        return gameRepository.saveGame(game);
    }

    @Override
    public Game removePlayerFromGame(Long idGame, Long idPlayer) {
        //At this level game and player should exist
        Game game = gameRepository.getById(idGame).get();
        game.removePlayerById(idPlayer);
        return gameRepository.saveGame(game);
    }
}
