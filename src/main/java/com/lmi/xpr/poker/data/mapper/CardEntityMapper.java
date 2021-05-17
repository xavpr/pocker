package com.lmi.xpr.poker.data.mapper;

import com.lmi.xpr.poker.data.entity.CardEntity;
import com.lmi.xpr.poker.domain.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardEntityMapper {

    @Mapping(target = "deckId", source = "deck.idDeck")
    Card toModel(CardEntity entity);
}
