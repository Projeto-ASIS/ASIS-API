package com.Asis.api.domain.usuario.controller.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UsuarioLoginRequestDTO {
    private String cpf;
    private String senha;
}
