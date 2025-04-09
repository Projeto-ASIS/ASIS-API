package com.Asis.api.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.Asis.api.domain.agendamento.controller.DTOs.response.AgendamentosResponseDTO;
import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;

public class UtilsMapping {

        public static List<AgendamentosResponseDTO> agendamentosToResponseDTO(List<AgendamentoEntity> agendamentos){
        List<AgendamentosResponseDTO> agendamentosResponse = agendamentos.stream()
        .map(AgendamentosResponseDTO::new)
        .collect(Collectors.toList());

        return agendamentosResponse;
    }
    
}
