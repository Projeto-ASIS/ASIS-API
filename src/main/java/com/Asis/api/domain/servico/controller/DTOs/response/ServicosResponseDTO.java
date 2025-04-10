package com.Asis.api.domain.servico.controller.DTOs.response;

import com.Asis.api.domain.servico.entity.ServicoEntity;

public record ServicosResponseDTO(
    int id,
    String nome
) {

    public ServicosResponseDTO (ServicoEntity entity){
        this(
            entity.getId(),
            entity.getNome()
        );
    }

}
