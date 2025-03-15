package com.Asis.api.domain.endereco.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2 , nullable = false)
    private String UF;

    @Column(length = 45, nullable = false)
    private String cidade;

    @Column(length = 9)
    private String CEP;

    @Column(nullable = false)
    private int numero;

    @Column(length = 100, nullable = false)
    private String logradouro;

    @Column(length = 100, nullable = false)
    private String complemento;

}
