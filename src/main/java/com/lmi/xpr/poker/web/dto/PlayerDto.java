package com.lmi.xpr.poker.web.dto;

import com.lmi.xpr.poker.domain.model.Card;
import lombok.Data;

import java.util.Set;

@Data
public class PlayerDto {
    private Long idPlayer;
    private String firstName;
    private String lastName;
    private Set<CardDto> cards;
}
