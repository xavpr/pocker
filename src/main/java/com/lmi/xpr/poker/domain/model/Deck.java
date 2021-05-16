package com.lmi.xpr.poker.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Deck {
    private Long idDeck;
    private List<Card> cards;
}
