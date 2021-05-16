package com.lmi.xpr.poker.data.mapper;

import com.lmi.xpr.poker.data.entity.CardEntity;
import com.lmi.xpr.poker.data.entity.DeckEntity;
import com.lmi.xpr.poker.domain.model.Card;
import com.lmi.xpr.poker.domain.model.Deck;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DeckEntityMapper {

    DeckEntity toEntity(Deck model);

    @Mapping(source = "cards", target = "cards", qualifiedByName = "mapCardsModels")
    Deck toModel(DeckEntity entity);

    List<Deck> toModels(List<DeckEntity> entities);

    Card toModel(CardEntity entity);

    @AfterMapping
    default void setDeckInCard(@MappingTarget DeckEntity entity) {
        entity.getCards().forEach(cardEntity -> cardEntity.setDeck(entity));
    }

    @Named("mapCardsModels")
    default List<Card> toCardModels(List<CardEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toCardModelWithDeckStatus)
                .collect(Collectors.toList());
    }


    default Card toCardModelWithDeckStatus(CardEntity entity) {
        Card card = toModel(entity);
        card.setAlreadyDealt(entity.getPlayer() != null);
        return card;
    }

}
