package com.diogosson.posto_combustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bomba_combustivel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BombaCombustivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "tipo_combustivel_id")
    private TipoCombustivel tipoCombustivel;

}
