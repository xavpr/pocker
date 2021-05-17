package com.lmi.xpr.poker.domain.model;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public List<Card> getAvailableCards() {
        return decks.stream().flatMap(d -> d.getCards().stream())
                .filter(c -> !c.isAlreadyDealt())
                .collect(Collectors.toList());
    }

    public List<Card> shuffleGameDeck() {
        List<Card> cards = getAvailableCards();
        int numberOfCards = cards.size();
        Random random = new Random();
        List<Integer> positions = IntStream.range(0, numberOfCards).boxed().collect(Collectors.toList());

        for (int i = 0; i < numberOfCards; i++) {
            int position = random.ints(0, positions.size()).findFirst().getAsInt();
            cards.get(i).setPosition(position);
            positions.remove(position);
        }
        return cards;
    }


    public Optional<Card> dealCardFromDecks() {
        return decks.stream().flatMap(d -> d.getCards().stream())
                .filter(c -> !c.isAlreadyDealt())
                .sorted(Comparator.comparingInt(Card::getPosition))
                .findFirst();
    }

    public List<Long> getDeckIds() {
        return decks.stream().map(Deck::getIdDeck).collect(Collectors.toList());
    }

    public List<Score> getGameScoreByPlayer() {
        List<Long> idDecks = getDeckIds();
        return players.stream()
                .map(p -> new Score(p.getFirstName(), p.getLastName(), p.getScoreByDeckId(idDecks)))
                .sorted(Comparator.comparingInt(Score::getScore).reversed())
                .collect(Collectors.toList());
    }

}
