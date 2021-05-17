package com.lmi.xpr.poker.data.mapper;

import com.lmi.xpr.poker.data.entity.CardEntity;
import com.lmi.xpr.poker.domain.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CardEntityMapper {

    @Mapping(target = "deckId", source = "deck.idDeck")
    @Mapping(target = "alreadyDealt", source = "idPlayer", qualifiedByName = "mapDealStatus")
    Card toModel(CardEntity entity);

    @Named("mapDealStatus")
    default boolean toModelWithCardDealtStatus(Long idPlayer) {
        return idPlayer != null;
    }
}
