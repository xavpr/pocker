package com.lmi.xpr.poker.data.repository;

import com.lmi.xpr.poker.data.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerEntityRepository extends JpaRepository<PlayerEntity, Long> {
}
