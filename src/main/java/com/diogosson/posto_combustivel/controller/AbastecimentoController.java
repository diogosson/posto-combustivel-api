package com.diogosson.posto_combustivel.controller;

import com.diogosson.posto_combustivel.infrastructure.entities.Abastecimento;
import com.diogosson.posto_combustivel.service.AbastecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/abastemcimento")
@RequiredArgsConstructor
public class AbastecimentoController {
    private final AbastecimentoService abastecimentoService;

    @PostMapping
    private ResponseEntity<Void> abastecer(
            @RequestParam("quantidadeLitros") Long quantidadeLitros,
            @RequestParam("idBomba") Integer idBomba
    ) {
        abastecimentoService.abastecer(idBomba, quantidadeLitros);
        return status(CREATED).build();
    }

    @GetMapping
    private ResponseEntity<List<Abastecimento>> listarAbastecimentos() {
        return ok(abastecimentoService.buscarAbastecimentos());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Abastecimento> buscarAbastecimentoPorId(@PathVariable Integer id) {
        return ok(abastecimentoService.buscarPorId(id));
    }
}
