package com.lmi.xpr.poker.domain.model;

import lombok.Data;

import java.util.Set;

@Data
public class Game {
    private Long idGame;
    private Set<Player> players;
    public void addPlayer(Player player) {
        players.add(player);
    }
    public void removePlayerById(Long idPlayer) {
        players.removeIf(p -> p.getIdPlayer().equals(idPlayer));
    }
}
