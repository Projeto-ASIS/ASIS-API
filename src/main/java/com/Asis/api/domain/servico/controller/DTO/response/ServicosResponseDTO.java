package com.Asis.api.domain.servico.controller.DTO.response;

import java.util.List;
import java.util.stream.Collectors;

import com.Asis.api.domain.servico.entity.ServicoEntity;

public record ServicosResponseDTO(
        int id,
        String nome) {

    public ServicosResponseDTO(ServicoEntity entity) {
        this(
            entity.getId(),
            entity.getNome()
        );
    }

    public static List<ServicosResponseDTO> servicosToListResponseDTO(List<ServicoEntity> servicos) {
        List<ServicosResponseDTO> servicosResponse = servicos.stream()
                .map(ServicosResponseDTO::new)
                .collect(Collectors.toList());

        return servicosResponse;
    }

}
