package com.diogosson.posto_combustivel.service;

import com.diogosson.posto_combustivel.dtos.BombaCombustivelRequest;
import com.diogosson.posto_combustivel.infrastructure.entities.BombaCombustivel;
import com.diogosson.posto_combustivel.infrastructure.entities.TipoCombustivel;
import com.diogosson.posto_combustivel.infrastructure.repositories.BombaCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BombaCombustivelService {

    private final BombaCombustivelRepository bombasCombustivelRepository;
    private final TipoCombustivelService tipoCombustivelService;

    public void criar(BombaCombustivelRequest request) {

        TipoCombustivel tipoCombustivel = tipoCombustivelService.buscarPorId(request.tipoCombustivelId());

        BombaCombustivel bombaCombustivel = new BombaCombustivel();
        bombaCombustivel.setNome(request.nome());
        bombaCombustivel.setTipoCombustivel(tipoCombustivel);

        bombasCombustivelRepository.save(bombaCombustivel);
    }

    public BombaCombustivel buscarPorId(Integer id) {
        return bombasCombustivelRepository
                    .findById(id)
                    .orElseThrow(() ->
                            new NullPointerException("Bomba de combustivel não encontrado pelo ID " + id));
    }

    @Transactional
    public void deletarPorId(Integer id) {

        boolean existeBomba = bombasCombustivelRepository.existsById(id);

        if (!existeBomba) {
            throw new NullPointerException("Bomba de combustivel não encontrado pelo ID " + id);
        }

        bombasCombustivelRepository.deleteById(id);
    }

    public void alterarPorId(Integer id, BombaCombustivelRequest request) {

        BombaCombustivel bombaEncontrada = buscarPorId(id);

        TipoCombustivel tipoCombustivel = tipoCombustivelService.buscarPorId(request.tipoCombustivelId());

        BombaCombustivel bombaCombustivel = new BombaCombustivel();

        bombaCombustivel.setId(bombaEncontrada.getId());
        bombaCombustivel.setNome(request.nome());
        bombaCombustivel.setTipoCombustivel(tipoCombustivel);

        bombasCombustivelRepository.save(bombaCombustivel);
    }
}
