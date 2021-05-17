package com.lmi.xpr.poker.domain.repository;

import com.lmi.xpr.poker.domain.model.Deck;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DeckRepository {
    Deck createDeck(Deck deck);
    List<Deck> getAll();
    boolean existsById(Long idDeck);
    Optional<Deck> getById(Long idDeck);
    void saveDecks(Set<Deck> decks);
}
