package com.Asis.api.domain.unidade.entity;

import com.Asis.api.domain.funcionario.entity.FuncionarioEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_unidade_funcionario")
public class UnidadeFuncionarioEntity {

    @Id
    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "funcionario_id")
    private FuncionarioEntity funcionario_id;

    @Id
    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "unidade_id")
    private UnidadeSUASEntity unidade_id;

    @Column(length = 45)
    private String funcao;
}
