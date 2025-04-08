package com.Asis.api.domain.usuario.controller.DTOs.response;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;


public record UsuarioLoginResponseDTO(
         String nomeCompleto,
         String email,
         String token,
         String role,
         String id
) {
    public UsuarioLoginResponseDTO(UsuarioEntity user, String token) {
        this(
                user.getNomeCompleto(),
                user.getEmail(),
                token,
                user.getRole().name(),
                user.getId().toString()
        );
    }
}
