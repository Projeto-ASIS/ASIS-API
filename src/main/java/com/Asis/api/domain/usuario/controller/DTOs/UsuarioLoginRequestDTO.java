package com.Asis.api.domain.usuario.controller.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public record UsuarioLoginRequestDTO(
        String cpf,
        String senha
) {
}
