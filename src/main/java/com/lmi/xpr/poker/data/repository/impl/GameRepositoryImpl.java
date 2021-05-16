package com.lmi.xpr.poker.data.repository.impl;

import com.lmi.xpr.poker.data.mapper.GameEntityMapper;
import com.lmi.xpr.poker.data.repository.GameEntityRepository;
import com.lmi.xpr.poker.domain.model.Game;
import com.lmi.xpr.poker.domain.repository.GameRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Slf4j
public class GameRepositoryImpl implements GameRepository {

    private final GameEntityRepository repository;

    private final GameEntityMapper mapper;

    @Override
    public Game createGame(Game game) {
        log.info("Starting game creation");
        Game result = mapper.toModel(repository.save(mapper.toEntity(game)));
        log.info("Game successfully created with id: {}", result.getIdGame());
        return result;
    }

    @Override
    public boolean existsById(Long idGame) {
        return repository.existsById(idGame);
    }

    @Override
    public Optional<Game> getById(Long idGame) {
        return Optional.ofNullable(mapper.toModel(repository.findById(idGame).orElse(null)));
    }

    @Override
    public Game saveGame(Game game) {
        log.info("Saving game id:{}", game.getIdGame());
        Game result = mapper.toModel(repository.save(mapper.toEntity(game)));
        log.info("Game successfully saved");
        return result;
    }


}
