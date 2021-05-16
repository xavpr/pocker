package com.lmi.xpr.poker.data.mapper;

import com.lmi.xpr.poker.data.entity.CardEntity;
import com.lmi.xpr.poker.domain.model.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardEntityMapper {
    Card toModel(CardEntity entity);
}
