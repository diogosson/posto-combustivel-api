package com.diogosson.posto_combustivel.controller;

import com.diogosson.posto_combustivel.dtos.TipoCombustivelRequest;
import com.diogosson.posto_combustivel.infrastructure.entities.TipoCombustivel;
import com.diogosson.posto_combustivel.service.TipoCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/tiposDeCombustivel")
@RequiredArgsConstructor
public class TipoCombustivelController {

    private final TipoCombustivelService tipoCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TipoCombustivelRequest request) {

        tipoCombustivelService.criar(request);

        return status(CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCombustivel> buscarPorId(@PathVariable Integer id) {
        return ok(tipoCombustivelService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        tipoCombustivelService.deletarPorId(id);

        return noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterarPorId(
            @PathVariable Integer id,
            @RequestBody TipoCombustivelRequest tipoCombustivel) {

        tipoCombustivelService.alterarPorId(id, tipoCombustivel);

        return noContent().build();
    }
}
