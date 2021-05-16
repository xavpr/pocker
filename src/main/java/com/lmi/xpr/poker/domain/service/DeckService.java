package com.lmi.xpr.poker.domain.service;

import com.lmi.xpr.poker.domain.model.Deck;

import java.util.List;

public interface DeckService {
    Deck createDeck();
    List<Deck> getAllDeck();
    boolean existsById(Long idDeck);
}
