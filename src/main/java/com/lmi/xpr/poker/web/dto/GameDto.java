package com.lmi.xpr.poker.web.dto;

import com.lmi.xpr.poker.domain.model.Player;
import lombok.Data;

import java.util.Set;

@Data
public class GameDto {
    private Long idGame;
    private Set<Player> players;
}
