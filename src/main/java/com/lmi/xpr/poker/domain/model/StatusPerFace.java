package com.lmi.xpr.poker.domain.model;

import com.lmi.xpr.poker.data.entity.Faces;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusPerFace {
    private Faces face;
    private int count;
}
