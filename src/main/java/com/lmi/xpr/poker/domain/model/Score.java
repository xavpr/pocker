package com.lmi.xpr.poker.domain.model;

import lombok.Data;

@Data
public class Score {
    String playerName;
    int score;

    public Score(String firstName, String lastName, int score) {
        this.playerName = firstName + " " + lastName;
        this.score = score;
    }
}
