package com.diogosson.posto_combustivel.infrastructure.repositories;

import com.diogosson.posto_combustivel.infrastructure.entities.TiposCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposCombustivelRepository extends JpaRepository<TiposCombustivel, Integer> {
}
