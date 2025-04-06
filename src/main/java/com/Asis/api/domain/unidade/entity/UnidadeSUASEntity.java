package com.Asis.api.domain.unidade.entity;

import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import com.Asis.api.domain.funcionario.entity.FuncionarioEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_unidade_suas")
public class UnidadeSUASEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private int cadsuas;

    @ManyToOne
    @JoinColumn(name = "endereco_unidade_id", nullable = false)
    private EnderecoEntity enderecoUnidade;

    @OneToOne()
    @JoinColumn(name = "gestor_id")
    private FuncionarioEntity gestor;

    @OneToMany(mappedBy = "unidade_id")
    private List<UnidadeFuncionarioEntity> unidadeFuncionario;
}

