package com.lmi.xpr.poker.domain.repository;

import com.lmi.xpr.poker.domain.model.Player;

import java.util.List;

public interface PlayerRepository {
    Player createPlayer(Player player);
    List<Player> getAll();
}
