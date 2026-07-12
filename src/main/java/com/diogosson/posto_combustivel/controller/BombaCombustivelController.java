package com.diogosson.posto_combustivel.controller;

import com.diogosson.posto_combustivel.infrastructure.entities.BombaCombustivel;
import com.diogosson.posto_combustivel.service.BombaCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/bombasDeCombustivel")
@RequiredArgsConstructor
public class BombaCombustivelController {

    private final BombaCombustivelService bombaCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombaCombustivel bombaCombustivel) {

        bombaCombustivelService.criar(bombaCombustivel);

        return status(CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombaCombustivel> buscarPorId(@PathVariable Integer id) {
        return ok(bombaCombustivelService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        bombaCombustivelService.deletarPorId(id);

        return noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterarPorId(
            @PathVariable Integer id,
            @RequestBody BombaCombustivel bombaCombustivel) {

        bombaCombustivelService.alterarPorId(id, bombaCombustivel);

        return noContent().build();
    }
}
