package com.Asis.api.domain.usuario.controller.DTOs.request;


public record UsuarioLoginRequestDTO(
        String cpf,
        String senha
) {
}
