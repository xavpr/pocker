package com.lmi.xpr.poker.domain.model;

import com.lmi.xpr.poker.data.entity.Suits;
import lombok.Data;

import java.util.List;

@Data
public class StatusPerSuit {
    private Suits suit;
    private int count;
    List<StatusPerFace> perFaces;
}
