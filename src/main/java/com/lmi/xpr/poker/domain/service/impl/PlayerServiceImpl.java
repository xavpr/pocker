package com.lmi.xpr.poker.domain.service.impl;

import com.lmi.xpr.poker.domain.model.Player;
import com.lmi.xpr.poker.domain.repository.PlayerRepository;
import com.lmi.xpr.poker.domain.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;

    @Override
    public Player createPlayer(Player player) {
        return repository.createPlayer(player);
    }

    @Override
    public List<Player> getAll() {
        return repository.getAll();
    }

    @Override
    public boolean existsById(Long idPlayer) {
        return repository.existsById(idPlayer);
    }
}
