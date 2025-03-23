package com.Asis.api.domain.usuario.controller.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioCadastroRequestDTO {

    private final String nomeCompleto;
    private final String email;
    private final String senha;
    private final String cpf;
    private final LocalDate dataNascimento;

}
