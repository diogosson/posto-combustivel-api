package com.diogosson.posto_combustivel.service;

import com.diogosson.posto_combustivel.infrastructure.entities.Abastecimento;
import com.diogosson.posto_combustivel.infrastructure.entities.BombaCombustivel;
import com.diogosson.posto_combustivel.infrastructure.repositories.AbastecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {
    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaCombustivelService bombaCombustivelService;

    public void abastecer(Integer id, Long quantidadeLitros) {
        BombaCombustivel bomba = bombaCombustivelService.buscarPorId(id);

        BigDecimal valorTotal = bomba
                .getTipoCombustivel()
                .getPrecoLitro()
                .multiply(BigDecimal.valueOf(quantidadeLitros));

        Abastecimento abastecimento = Abastecimento
                .builder()
                .bombaCombustivel(bomba)
                .dataAbastecimento(LocalDate.now())
                .quantidadeLitros(quantidadeLitros)
                .valorTotal(valorTotal)
                .build();

        abastecimentoRepository.save(abastecimento);
    }

    public Abastecimento buscarPorId(Integer id) {
        return abastecimentoRepository
                .findById(id)
                .orElseThrow(() ->
                        new NullPointerException("Abastecimento não encontrado pelo ID " + id));
    }

    public List<Abastecimento> buscarAbastecimentos() {
        return abastecimentoRepository.findAll();
    }
}
