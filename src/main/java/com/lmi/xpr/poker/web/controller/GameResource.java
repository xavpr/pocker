package com.lmi.xpr.poker.web.controller;


import com.lmi.xpr.poker.domain.service.GameService;
import com.lmi.xpr.poker.web.dto.GameDto;
import com.lmi.xpr.poker.web.mapper.GameDtoMapper;
import com.lmi.xpr.poker.web.validator.game.GameExists;
import com.lmi.xpr.poker.web.validator.player.PlayerExists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("{id}/{idPlayer}")
    @ApiOperation("Add player to a game")
    public GameDto addPlayer(@GameExists @PathVariable long id, @PlayerExists @PathVariable long idPlayer) {
     return mapper.toDto(service.addPlayerToGame(id, idPlayer));
    }

}
