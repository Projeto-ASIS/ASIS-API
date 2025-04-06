package com.Asis.api.domain.servico.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_servico")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 500, nullable = false)
    private String descricao;

    @Column(length = 500, nullable = false, name = "como_acessar")
    private String comoAcessar;

    @Column(length = 100, nullable = true, name = "link_acesso")
    private String linkAcesso;

}
