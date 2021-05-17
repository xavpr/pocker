package com.lmi.xpr.poker.domain.model;

import com.lmi.xpr.poker.data.entity.Faces;
import com.lmi.xpr.poker.data.entity.Suits;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class GameDeckStatus {

    @Getter
    private List<StatusPerSuit> statusPerSuits = new ArrayList<>();

    public void init(List<Card> cards) {
        Arrays.stream(Suits.values()).forEach(s -> {
            StatusPerSuit sps = new StatusPerSuit();
            sps.setSuit(s);
            sps.setCount(cards.stream().filter(c -> c.getSuit().equals(s)).collect(Collectors.toSet()).size());

            List<StatusPerFace> perFaces =
                    Arrays.stream(Faces.values())
                            .sorted(Comparator.comparingInt(Faces::getValue).reversed())
                            .map(f -> new StatusPerFace(f, cards.stream().filter(c -> c.getSuit().equals(s) && c.getFace().equals(f)).collect(Collectors.toSet()).size()))
                            .collect(Collectors.toList());
            sps.setPerFaces(perFaces);
            statusPerSuits.add(sps);
        });
    }
}
