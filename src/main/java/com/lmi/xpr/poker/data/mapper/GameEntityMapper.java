package com.lmi.xpr.poker.data.mapper;

import com.lmi.xpr.poker.data.entity.GameEntity;
import com.lmi.xpr.poker.domain.model.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { CardEntityMapper.class })
public interface GameEntityMapper {
    GameEntity toEntity(Game model);
    Game toModel(GameEntity entity);
}
