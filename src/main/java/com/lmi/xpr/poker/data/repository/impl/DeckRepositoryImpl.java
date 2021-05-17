package com.lmi.xpr.poker.data.repository.impl;

import com.lmi.xpr.poker.data.entity.DeckEntity;
import com.lmi.xpr.poker.data.mapper.DeckEntityMapper;
import com.lmi.xpr.poker.data.repository.DeckEntityRepository;
import com.lmi.xpr.poker.domain.model.Deck;
import com.lmi.xpr.poker.domain.repository.DeckRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public boolean existsById(Long idDeck) {
        return repository.existsById(idDeck);
    }

    @Override
    public Optional<Deck> getById(Long idDeck) {
        return Optional.ofNullable(mapper.toModel(repository.findById(idDeck).orElse(null)));
    }

    @Override
    public void saveDecks(Set<Deck> decks) {
        //TODO fix mapper then go for saveAll
        decks.stream().forEach(
                deck -> {
                    DeckEntity toSave = mapper.toEntity(deck);
                    repository.save(toSave);
                }
        );
    }

}
