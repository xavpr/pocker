package com.lmi.xpr.poker.data.repository;

import com.lmi.xpr.poker.data.entity.DeckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckEntityRepository extends JpaRepository<DeckEntity, Long> {
}
