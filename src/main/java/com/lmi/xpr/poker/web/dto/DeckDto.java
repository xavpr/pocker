package com.lmi.xpr.poker.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeckDto {
    private Integer idDeck;
    private List<CardDto> cards;
}
