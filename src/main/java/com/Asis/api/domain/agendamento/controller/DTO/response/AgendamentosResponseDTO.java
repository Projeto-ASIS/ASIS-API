package com.Asis.api.domain.agendamento.controller.DTO.response;

import java.util.List;
import java.util.stream.Collectors;

import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;

public record AgendamentosResponseDTO(String dataAtendimento, String nomeCompleto, byte statusAtendimento, String servico) {

    public AgendamentosResponseDTO(AgendamentoEntity entity) {
        this(
            entity.getDataAtendimento().toString(),
            entity.getUsuario().getNomeCompleto(),
            entity.getStatusAgendamento(),
            entity.getServico().getNome()
            );
    }

        public static List<AgendamentosResponseDTO> agendamentosToListResponseDTO(List<AgendamentoEntity> agendamentos) {
        List<AgendamentosResponseDTO> agendamentosResponse = agendamentos.stream()
                .map(AgendamentosResponseDTO::new)
                .collect(Collectors.toList());

        return agendamentosResponse;
    }
}
