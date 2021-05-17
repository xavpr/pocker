package com.lmi.xpr.poker.web.controller;


import com.lmi.xpr.poker.domain.model.Score;
import com.lmi.xpr.poker.domain.service.GameService;
import com.lmi.xpr.poker.web.dto.GameDto;
import com.lmi.xpr.poker.web.mapper.GameDtoMapper;
import com.lmi.xpr.poker.web.validator.deck.DeckExists;
import com.lmi.xpr.poker.web.validator.game.GameExists;
import com.lmi.xpr.poker.web.validator.player.PlayerExists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@Api(tags = {"PokerGameApi"})
@AllArgsConstructor
@Validated
public class GameResource {

    private final GameService service;
    private final GameDtoMapper mapper;

    @PostMapping
    @ApiOperation("Create a game")
    public GameDto createDeck() {
        return mapper.toDto(service.createGame());
    }

    @PutMapping("{idGame}/player/{idPlayer}/add")
    @ApiOperation("Add player to a game")
    public GameDto addPlayer(@GameExists @PathVariable long idGame, @PlayerExists @PathVariable long idPlayer) {
     return mapper.toDto(service.addPlayerToGame(idGame, idPlayer));
    }

    @PutMapping("{idGame}/player/{idPlayer}/remove")
    @ApiOperation("Remove player from a game")
    public GameDto removePlayer(@GameExists @PathVariable long idGame, @PlayerExists @PathVariable long idPlayer) {
        return mapper.toDto(service.addPlayerToGame(idGame, idPlayer));
    }

    @PutMapping("{idGame}/deck/{idDeck}/add")
    @ApiOperation("Add deck to a game")
    public GameDto addDeck(@GameExists @PathVariable long idGame, @DeckExists @PathVariable long idDeck) {
        return mapper.toDto(service.addDeckToGame(idGame, idDeck));
    }

    @PutMapping("{idGame}/player/{idPlayer}/deal-card")
    @ApiOperation("Deal a card from deck game to given player")
    public void dealCard(@GameExists @PathVariable long idGame, @PlayerExists @PathVariable long idPlayer) {
        service.dealCard(idGame, idPlayer);
    }

    @GetMapping("{idGame}/score")
    @ApiOperation("Get score by game id")
    public List<Score> getGameScore(@GameExists @PathVariable long idGame) {
        return service.getScore(idGame);
    }

    @GetMapping("{idGame}/shuffle")
    @ApiOperation("Shuffle game deck")
    public void shuffleGame(@GameExists @PathVariable long idGame) {
        service.shuffle(idGame);
    }

}
