package com.Asis.api.domain.unidade.entity;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_unidade_funcionario")
public class UnidadeFuncionarioEntity {

    @EmbeddedId
    private UnidadeFuncionarioId id;

    @MapsId(value = "usuarioId")
    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @MapsId(value = "unidadeId")
    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "unidade_id")
    private UnidadeSUASEntity unidade;

    @Column(length = 45)
    private String funcao;
}
