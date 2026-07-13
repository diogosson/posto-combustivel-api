package com.diogosson.posto_combustivel.service;

import com.diogosson.posto_combustivel.dtos.TipoCombustivelRequest;
import com.diogosson.posto_combustivel.infrastructure.entities.TipoCombustivel;
import com.diogosson.posto_combustivel.infrastructure.repositories.TipoCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoCombustivelService {

    private final TipoCombustivelRepository tipoCombustivelRepository;

    public void criar(TipoCombustivelRequest request) {

        TipoCombustivel tipoCombustivel = new TipoCombustivel();
        tipoCombustivel.setNome(request.nome());
        tipoCombustivel.setPrecoLitro(request.precoLitro());

        tipoCombustivelRepository.save(tipoCombustivel);
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

    public void alterarPorId(Integer id, TipoCombustivelRequest request) {

        TipoCombustivel tipoEncontrado = buscarPorId(id);

        TipoCombustivel tipoCombustivel = new TipoCombustivel();

        tipoCombustivel.setId(tipoEncontrado.getId());
        tipoCombustivel.setNome(request.nome());
        tipoCombustivel.setPrecoLitro(request.precoLitro());

        tipoCombustivelRepository.save(tipoCombustivel);
    }
}
