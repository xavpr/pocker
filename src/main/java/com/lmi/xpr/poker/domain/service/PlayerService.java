package com.lmi.xpr.poker.domain.service;

import com.lmi.xpr.poker.domain.model.Player;

import java.util.List;

public interface PlayerService {
    Player createPlayer(Player player);
    List<Player> getAll();
}
