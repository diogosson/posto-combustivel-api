package com.diogosson.posto_combustivel.dtos;

import java.math.BigDecimal;

public record TipoCombustivelRequest(
        String nome,
        BigDecimal precoLitro
) {
}
