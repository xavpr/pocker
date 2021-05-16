package com.lmi.xpr.poker.domain.service.impl;

import com.lmi.xpr.poker.data.entity.Suits;
import com.lmi.xpr.poker.domain.model.Deck;
import com.lmi.xpr.poker.domain.repository.DeckRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DeckServiceImplTest {

    private EasyRandom easyRandom;

    @Spy
    private DeckRepository repository;

    @InjectMocks
    private DeckServiceImpl service;

    @Captor
    private ArgumentCaptor<Deck> captor;

    @BeforeEach
    public void setUp() {
        easyRandom = new EasyRandom();
    }

    @Test
    public void createDeckShouldCreateNewDeckWith52CardsAnd13BySuit() {
        when(repository.createDeck(any(Deck.class))).thenReturn(easyRandom.nextObject(Deck.class));
        service.createDeck();
        verify(repository).createDeck(captor.capture());
        Deck result = captor.getValue();

        assertEquals(52, result.getCards().size());
        assertEquals(13, result.getCards().stream().filter(c -> c.getSuit().equals(Suits.CLUBS)).collect(Collectors.toList()).size());
        assertEquals(13, result.getCards().stream().filter(c -> c.getSuit().equals(Suits.DIAMONDS)).collect(Collectors.toList()).size());
        assertEquals(13, result.getCards().stream().filter(c -> c.getSuit().equals(Suits.HEARTS)).collect(Collectors.toList()).size());
        assertEquals(13, result.getCards().stream().filter(c -> c.getSuit().equals(Suits.SPADES)).collect(Collectors.toList()).size());
    }



}