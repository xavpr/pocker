package com.lmi.xpr.poker.web.controller;

import com.lmi.xpr.poker.domain.service.DeckService;
import com.lmi.xpr.poker.web.dto.DeckDto;
import com.lmi.xpr.poker.web.mapper.DeckDtoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deck")
@Api(tags = {"PokerDeckApi"})
@AllArgsConstructor
public class DeckResource {

    private final DeckDtoMapper deckDtoMapper;
    private final DeckService deckService;

    @PostMapping
    @ApiOperation("Create a deck")
    public DeckDto createDeck() {
        return deckDtoMapper.toDto(deckService.createDeck());
    }

    @GetMapping("/all")
    @ApiOperation("Get the list of deck")
    public List<DeckDto> getAllDeck() {
        return deckDtoMapper.toDtos(deckService.getAllDeck());
    }

}
