package com.lmi.xpr.poker.domain.repository;

import com.lmi.xpr.poker.domain.model.Deck;

import java.util.List;

public interface DeckRepository {
    Deck createDeck(Deck deck);
    List<Deck> getAll();
}
