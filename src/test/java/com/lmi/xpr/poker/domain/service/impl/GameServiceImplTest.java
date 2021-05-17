package com.lmi.xpr.poker.domain.service.impl;

import com.lmi.xpr.poker.domain.model.Deck;
import com.lmi.xpr.poker.domain.model.Game;
import com.lmi.xpr.poker.domain.model.Player;
import com.lmi.xpr.poker.domain.repository.DeckRepository;
import com.lmi.xpr.poker.domain.repository.GameRepository;
import com.lmi.xpr.poker.domain.repository.PlayerRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceImplTest {

    @Spy
    private GameRepository gameRepository;
    @Spy
    private PlayerRepository playerRepository;
    @Spy
    private DeckRepository deckRepository;

    @InjectMocks
    private GameServiceImpl service;

    private EasyRandom random;

    @Captor
    private ArgumentCaptor<Game> captor;


    @BeforeEach
    public void setUp() {
        random = new EasyRandom();
    }

    @Test
    public void shouldAddPlayerToGame() {
        Game game = random.nextObject(Game.class);
        game.getPlayers().clear();
        Player player = random.nextObject(Player.class);

        when(gameRepository.getById(game.getIdGame())).thenReturn(Optional.of(game));
        when(playerRepository.getById(player.getIdPlayer())).thenReturn(Optional.of(player));
        when(gameRepository.saveGame(game)).thenReturn(game);

        service.addPlayerToGame(game.getIdGame(), player.getIdPlayer());
        verify(gameRepository).saveGame(captor.capture());

        Game result = captor.getValue();

        assertThat(result.getPlayers()).isNotEmpty();
        assertThat(result.getPlayers().iterator().next()).isEqualTo(player);
    }

    @Test
    public void shouldAddDeckToGame() {
        Game game = random.nextObject(Game.class);
        game.getDecks().clear();
        Deck deck = random.nextObject(Deck.class);

        when(gameRepository.getById(game.getIdGame())).thenReturn(Optional.of(game));
        when(deckRepository.getById(deck.getIdDeck())).thenReturn(Optional.of(deck));
        when(gameRepository.saveGame(game)).thenReturn(game);

        service.addDeckToGame(game.getIdGame(), deck.getIdDeck());
        verify(gameRepository).saveGame(captor.capture());

        Game result = captor.getValue();

        assertThat(result.getDecks()).isNotEmpty();
        assertThat(result.getDecks().iterator().next()).isEqualTo(deck);
    }

}