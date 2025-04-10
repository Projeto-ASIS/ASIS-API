package com.Asis.api.domain.usuario.controller.DTO.request;


public record UsuarioLoginRequestDTO(
        String cpf,
        String senha
) {
}
