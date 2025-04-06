package com.Asis.api.domain.endereco.DTOs;

public record EnderecoAgendamentoRequestDTO(
    String UF,
    String cidade,
    String CEP,
    int numero,
    String logradouro,
    String complemento

) {

}
