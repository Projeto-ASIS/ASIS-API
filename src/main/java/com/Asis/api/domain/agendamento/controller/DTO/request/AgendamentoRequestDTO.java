package com.Asis.api.domain.agendamento.controller.DTO.request;

import java.time.LocalDate;

import com.Asis.api.domain.endereco.DTO.request.EnderecoRequestDTO;

public record AgendamentoRequestDTO(
    String CPF,
    String nomeMae,
    LocalDate dataNascimento,
    String email,
    String telefone1,
    String telefone2,
    int servicoId,
    int unidadeId,
    String cadunico,
    String nis,
    EnderecoRequestDTO endereco,
    LocalDate dataAtendimento
) {

}
