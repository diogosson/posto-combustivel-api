package com.diogosson.posto_combustivel.dtos;

public record BombaCombustivelRequest(
        String nome,
        Integer tipoCombustivelId
) {
}
