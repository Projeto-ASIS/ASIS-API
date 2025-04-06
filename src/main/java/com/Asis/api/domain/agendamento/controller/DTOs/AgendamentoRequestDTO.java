package com.Asis.api.domain.agendamento.controller.DTOs;

import java.time.LocalDate;

import com.Asis.api.domain.endereco.DTOs.EnderecoAgendamentoRequestDTO;

public record AgendamentoRequestDTO(
    String cpf,
    String nomeMae,
    LocalDate dataNascimento,
    int servicoId,
    String cadunico,
    String nis,
    EnderecoAgendamentoRequestDTO endereco,
    LocalDate dataAtendimento
) {

}
