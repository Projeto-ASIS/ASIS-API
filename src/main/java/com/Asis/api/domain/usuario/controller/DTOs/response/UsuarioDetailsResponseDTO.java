package com.Asis.api.domain.usuario.controller.DTOs.response;

public record UsuarioDetailsResponseDTO(
    String nomeCompleto,
    String email,
    String role
) {

}
