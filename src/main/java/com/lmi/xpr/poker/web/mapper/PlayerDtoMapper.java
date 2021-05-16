package com.lmi.xpr.poker.web.mapper;

import com.lmi.xpr.poker.domain.model.Player;
import com.lmi.xpr.poker.web.dto.PlayerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerDtoMapper {
    PlayerDto toDto(Player model);
    Player toModel(PlayerDto dto);
    List<PlayerDto> toDtos(List<Player> models);
}
