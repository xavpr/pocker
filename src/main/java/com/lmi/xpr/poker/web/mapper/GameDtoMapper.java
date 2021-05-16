package com.lmi.xpr.poker.web.mapper;

import com.lmi.xpr.poker.domain.model.Game;
import com.lmi.xpr.poker.web.dto.GameDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameDtoMapper {
    GameDto toDto(Game model);
}
