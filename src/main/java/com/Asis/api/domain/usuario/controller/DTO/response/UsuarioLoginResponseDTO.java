package com.Asis.api.domain.usuario.controller.DTO.response;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;


public record UsuarioLoginResponseDTO(
         String nomeCompleto,
         String token,
         String role
) {
    public UsuarioLoginResponseDTO(UsuarioEntity user, String token) {
        this(
                user.getNomeCompleto(),
                token,
                user.getRole().name()
        );
    }
}
