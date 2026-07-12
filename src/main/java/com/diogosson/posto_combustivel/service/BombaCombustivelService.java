package com.diogosson.posto_combustivel.service;

import com.diogosson.posto_combustivel.infrastructure.entities.BombaCombustivel;
import com.diogosson.posto_combustivel.infrastructure.repositories.BombaCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BombaCombustivelService {

    private final BombaCombustivelRepository bombasCombustivelRepository;

    public void criar(BombaCombustivel bomba) {
        bombasCombustivelRepository.save(bomba);
    }

    public BombaCombustivel buscarPorId(Integer id) {
        return bombasCombustivelRepository
                    .findById(id)
                    .orElseThrow(() ->
                            new NullPointerException("Bomba de combustivel não encontrado pelo ID " + id));
    }

    @Transactional
    private void deletarPorId(Integer id) {

        boolean existeBomba = bombasCombustivelRepository.existsById(id);

        if (!existeBomba) {
            throw new NullPointerException("Bomba de combustivel não encontrado pelo ID " + id);
        }

        bombasCombustivelRepository.deleteById(id);
    }

    private void alterarPorId(Integer id, BombaCombustivel bomba) {

        BombaCombustivel bombaEncontrada = buscarPorId(id);
        bomba.setId(bombaEncontrada.getId());

        bombasCombustivelRepository.save(bomba);
    }
}
