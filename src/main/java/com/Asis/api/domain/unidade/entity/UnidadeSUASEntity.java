package com.Asis.api.domain.unidade.entity;

import lombok.Getter;
import lombok.Setter;
import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_unidade_suas")
public class UnidadeSUASEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cadsuas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_unidade_id", nullable = false)
    private EnderecoEntity enderecoUnidade;

    @OneToOne()
    @JoinColumn(name = "gestor_id")
    private UsuarioEntity gestor;

    @OneToMany(mappedBy = "unidade")
    private List<UnidadeFuncionarioEntity> unidadeFuncionario;
}

