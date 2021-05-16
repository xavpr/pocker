package com.lmi.xpr.poker.data.mapper;

import com.lmi.xpr.poker.data.entity.PlayerEntity;
import com.lmi.xpr.poker.domain.model.Player;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerEntityMapper {
    Player toModel(PlayerEntity entity);
    PlayerEntity toEntity(Player model);
    List<Player> toModels(List<PlayerEntity> entities);
}
