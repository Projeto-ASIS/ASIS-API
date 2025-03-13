package com.Asis.api.domain.servico.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "tb_servico")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 500, nullable = false)
    private String descricao;

    @Column(length = 500, nullable = false)
    private String comoAcessar;

    @Column(length = 100, nullable = true)
    private String linkAcesso;

}
