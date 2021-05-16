package com.lmi.xpr.poker.web.mapper;

import com.lmi.xpr.poker.domain.model.Deck;
import com.lmi.xpr.poker.web.dto.DeckDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeckDtoMapper {
    DeckDto toDto(Deck model);
    List<DeckDto> toDtos(List<Deck> models);
}
