package com.Asis.api.domain.unidade.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UnidadeFuncionarioId implements Serializable {

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "unidade_id")
    private Long unidadeId;

}
