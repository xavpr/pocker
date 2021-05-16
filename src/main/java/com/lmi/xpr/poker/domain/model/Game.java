package com.lmi.xpr.poker.domain.model;

import lombok.Data;

import java.util.Optional;
import java.util.Set;

@Data
public class Game {
    private Long idGame;
    private Set<Player> players;
    private Set<Deck> decks;
    public void addPlayer(Player player) {
        players.add(player);
    }
    public void removePlayerById(Long idPlayer) {
        players.removeIf(p -> p.getIdPlayer().equals(idPlayer));
    }
    public void addDeck(Deck deck) {
        decks.add(deck);
    }
    public Optional<Card> dealCardFromDecks() {
        return decks.stream().flatMap(d -> d.getCards().stream())
                .filter(c -> !c.isAlreadyDealt()).findFirst();
    }
}
