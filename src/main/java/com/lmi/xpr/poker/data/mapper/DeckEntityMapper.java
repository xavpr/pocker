package com.lmi.xpr.poker.data.mapper;

import com.lmi.xpr.poker.data.entity.DeckEntity;
import com.lmi.xpr.poker.domain.model.Deck;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeckEntityMapper {

    DeckEntity toEntity(Deck model);

    Deck toModel(DeckEntity entity);

    List<Deck> toModels(List<DeckEntity> entities);

    @AfterMapping
    default void setDeckInCard(@MappingTarget DeckEntity entity) {
        entity.getCards().forEach(cardEntity -> cardEntity.setDeck(entity));
    }

}
