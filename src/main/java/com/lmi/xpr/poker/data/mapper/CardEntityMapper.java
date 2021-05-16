package com.lmi.xpr.poker.data.mapper;

import com.lmi.xpr.poker.data.entity.CardEntity;
import com.lmi.xpr.poker.domain.model.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardEntityMapper {
    List<CardEntity> toEntities(List<Card> models);
    List<Card> toModels(List<CardEntity> entities);
}
