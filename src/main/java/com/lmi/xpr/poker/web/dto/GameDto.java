package com.lmi.xpr.poker.web.dto;

import lombok.Data;

import java.util.Set;

@Data
public class GameDto {
    private Long idGame;
    private Set<PlayerDto> players;
    private Set<DeckDto> decks;
}
