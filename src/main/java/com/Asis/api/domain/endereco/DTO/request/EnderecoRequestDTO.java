package com.Asis.api.domain.endereco.DTO.request;

public record EnderecoRequestDTO(
    String UF,
    String cidade,
    String logradouro,
    String complemento,
    String CEP,
    Integer numero
) {

}
