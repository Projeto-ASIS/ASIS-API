package com.Asis.api.domain.agendamento.controller.DTO.request;

import java.time.LocalDate;


public record AgendamentoRequestDTO(
    String CPF,
    String nomeMae,
    LocalDate dataNascimento,
    String telefone1,
    String telefone2,
    int servicoId,
    int unidadeId,
    String cadunico,
    String nis,
    LocalDate dataAtendimento
) {

}
