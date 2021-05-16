package com.lmi.xpr.poker.domain.model;

import lombok.Data;

import java.util.Optional;
import java.util.Set;

@Data
public class Player {
    private Long idPlayer;
    private String firstName;
    private String lastName;
    private Set<Card> cards;
    public void receiveACard(Optional<Card> card) {
        card.ifPresent(c -> cards.add(c));
    }
}
