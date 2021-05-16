package com.lmi.xpr.poker.web.dto;

import com.lmi.xpr.poker.data.entity.Faces;
import com.lmi.xpr.poker.data.entity.Suits;
import lombok.Data;

@Data
public class CardDto {
    private Long idCard;
    private Suits suit;
    private Faces face;
}
