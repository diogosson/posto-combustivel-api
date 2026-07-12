package com.diogosson.posto_combustivel.service;

import com.diogosson.posto_combustivel.infrastructure.entities.TipoCombustivel;
import com.diogosson.posto_combustivel.infrastructure.repositories.TipoCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoCombustivelService {

    private final TipoCombustivelRepository tipoCombustivelRepository;

    public void criar(TipoCombustivel tipo) {
        tipoCombustivelRepository.save(tipo);
    }

    public TipoCombustivel buscarPorId(Integer id) {
        return tipoCombustivelRepository
                    .findById(id)
                    .orElseThrow(() ->
                            new NullPointerException("Tipo de combustivel não encontrado pelo ID " + id));
    }

    @Transactional
    public void deletarPorId(Integer id) {

        boolean existeTipo = tipoCombustivelRepository.existsById(id);

        if (!existeTipo) {
            throw new NullPointerException("Tipo de combustivel não encontrado pelo ID " + id);
        }

        tipoCombustivelRepository.deleteById(id);
    }

    public void alterarPorId(Integer id, TipoCombustivel tipo) {

        TipoCombustivel tipoEncontrado = buscarPorId(id);
        tipo.setId(tipoEncontrado.getId());

        tipoCombustivelRepository.save(tipo);
    }
}
