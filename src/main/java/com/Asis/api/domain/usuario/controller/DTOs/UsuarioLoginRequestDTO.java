package com.Asis.api.domain.usuario.controller.DTOs;


public record UsuarioLoginRequestDTO(
        String cpf,
        String senha
) {
}
