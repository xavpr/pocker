package com.lmi.xpr.poker.data.repository;

import com.lmi.xpr.poker.data.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameEntityRepository extends JpaRepository<GameEntity, Long> {

    boolean existsByIdGameEquals(Long idGame);
}
