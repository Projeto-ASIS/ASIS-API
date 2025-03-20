package com.Asis.api.domain.Unidade.entity;

import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_unidadeSUAS")
public class UnidadeSUASEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private int cadSuas;

    @ManyToOne
    @JoinColumn(name = "enderecoUnidade_id", nullable = false)
    private EnderecoEntity enderecoUnidade;
}

