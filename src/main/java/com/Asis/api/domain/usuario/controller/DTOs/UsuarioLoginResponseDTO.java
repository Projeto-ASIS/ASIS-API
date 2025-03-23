package com.Asis.api.domain.usuario.controller.DTOs;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public record UsuarioLoginResponseDTO(
         String nomeCompleto,
         String email,
         String token,
         String role
) {
    public UsuarioLoginResponseDTO(UsuarioEntity user, String token) {
        this(
                user.getNomeCompleto(),
                user.getEmail(),
                token,
                user.getRole().name()
        );
    }
}
