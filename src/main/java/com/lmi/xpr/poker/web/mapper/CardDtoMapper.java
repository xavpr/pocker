package com.lmi.xpr.poker.web.mapper;

import com.lmi.xpr.poker.domain.model.Card;
import com.lmi.xpr.poker.web.dto.CardDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardDtoMapper {
    CardDto toDto(Card model);
    List<CardDto> toDtos(List<Card> models);
}
