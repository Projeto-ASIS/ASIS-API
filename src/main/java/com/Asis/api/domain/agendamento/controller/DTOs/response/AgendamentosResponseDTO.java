package com.Asis.api.domain.agendamento.controller.DTOs.response;

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
}
