package com.Asis.api.domain.unidade.controller.DTO.response;

import java.util.List;
import java.util.stream.Collectors;

import com.Asis.api.domain.unidade.entity.UnidadeSUASEntity;

public record UnidadeResponseDTO( Integer id, String nome) {

    public UnidadeResponseDTO(UnidadeSUASEntity entity){
        this(entity.getId(), entity.getNome());
    }

    public static List<UnidadeResponseDTO> unidadesToListResponseDTO(List<UnidadeSUASEntity> unidades){
        List<UnidadeResponseDTO> unidadesResponse =  unidades.stream()
               .map(UnidadeResponseDTO::new)
               .collect(Collectors.toList());

        return unidadesResponse;
    }
}
