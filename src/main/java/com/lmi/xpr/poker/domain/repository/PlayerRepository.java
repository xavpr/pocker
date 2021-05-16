package com.lmi.xpr.poker.domain.repository;

import com.lmi.xpr.poker.domain.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {
    Player createPlayer(Player player);
    List<Player> getAll();
    Optional<Player> getById(Long idPlayer);
    boolean existsById(Long idPlayer);
}
