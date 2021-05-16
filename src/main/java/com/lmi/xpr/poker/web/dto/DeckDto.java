package com.lmi.xpr.poker.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeckDto {
    private Long idDeck;
    private List<CardDto> cards;
}
