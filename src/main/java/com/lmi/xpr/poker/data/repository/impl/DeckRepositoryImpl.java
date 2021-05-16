package com.lmi.xpr.poker.data.repository.impl;

import com.lmi.xpr.poker.data.entity.DeckEntity;
import com.lmi.xpr.poker.data.mapper.DeckEntityMapper;
import com.lmi.xpr.poker.data.repository.DeckEntityRepository;
import com.lmi.xpr.poker.domain.model.Deck;
import com.lmi.xpr.poker.domain.repository.DeckRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DeckRepositoryImpl implements DeckRepository {

    private final DeckEntityRepository repository;
    private final DeckEntityMapper mapper;

    @Override
    public Deck createDeck(Deck deck) {
        DeckEntity toSave = mapper.toEntity(deck);
        return mapper.toModel(repository.save(toSave));
    }

    @Override
    public List<Deck> getAll() {
        return mapper.toModels(repository.findAll());
    }
}
