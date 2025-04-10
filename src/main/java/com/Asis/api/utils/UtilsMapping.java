package com.Asis.api.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.Asis.api.domain.agendamento.controller.DTOs.response.AgendamentosResponseDTO;
import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import com.Asis.api.domain.servico.controller.DTOs.response.ServicosResponseDTO;
import com.Asis.api.domain.servico.entity.ServicoEntity;

public class UtilsMapping {

    public static List<AgendamentosResponseDTO> agendamentosToResponseDTO(List<AgendamentoEntity> agendamentos) {
        List<AgendamentosResponseDTO> agendamentosResponse = agendamentos.stream()
                .map(AgendamentosResponseDTO::new)
                .collect(Collectors.toList());

        return agendamentosResponse;
    }

    public static List<ServicosResponseDTO> servicosToResponseDTO(List<ServicoEntity> servicos) {
        List<ServicosResponseDTO> servicosResponse = servicos.stream()
                .map(ServicosResponseDTO::new)
                .collect(Collectors.toList());

        return servicosResponse;
    }


}
