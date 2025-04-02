package com.Asis.api.domain.usuario.controller.DTOs;

public record UsuarioDetailsResponseDTO(
    String nomeCompleto,
    String email,
    String role
) {

}
