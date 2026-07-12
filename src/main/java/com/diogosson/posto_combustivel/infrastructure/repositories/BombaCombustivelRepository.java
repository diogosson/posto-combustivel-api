package com.diogosson.posto_combustivel.infrastructure.repositories;

import com.diogosson.posto_combustivel.infrastructure.entities.BombaCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombaCombustivelRepository extends JpaRepository<BombaCombustivel, Integer> {
}
