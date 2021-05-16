package com.lmi.xpr.poker.domain.service.impl;

import com.lmi.xpr.poker.data.entity.Faces;
import com.lmi.xpr.poker.data.entity.Suits;
import com.lmi.xpr.poker.domain.model.Card;
import com.lmi.xpr.poker.domain.model.Deck;
import com.lmi.xpr.poker.domain.repository.DeckRepository;
import com.lmi.xpr.poker.domain.service.DeckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DeckServiceImpl implements DeckService {

    private final DeckRepository deckRepository;


    @Override
    public Deck createDeck() {
        log.info("Starting deck creation");
        Deck deck = new Deck();
        List<Card> cards = Arrays.stream(Suits.values())
                .flatMap(s -> Arrays.stream(Faces.values())
                .map(f -> new Card(s, f)))
                .collect(Collectors.toList());
        deck.setCards(cards);
        Deck result = deckRepository.createDeck(deck);
        log.info("Deck successfully created with id: {}", result.getIdDeck());
        return result;
    }

    @Override
    public List<Deck> getAllDeck() {
        return deckRepository.getAll();
    }
}
