package com.lmi.xpr.poker.domain.model;

import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Player {
    private Long idPlayer;
    private String firstName;
    private String lastName;
    private Set<Card> cards;
    public void receiveACard(Optional<Card> card) {
        card.ifPresent(c -> cards.add(c));
    }
    public int getScoreByDeckId(List<Long> ids) {
        return cards.stream()
                .filter(card -> ids.contains(card.getDeckId()))
                .map(card -> card.getFace().getValue())
                .collect(Collectors.summingInt(Integer::intValue));

    }
    public List<Card> getPlayerHandGameByDeckIds(List<Long> ids) {
        return cards.stream().filter(card -> ids.contains(card.getDeckId()))
                .collect(Collectors.toList());
    }
}
