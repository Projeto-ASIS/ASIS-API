package com.Asis.api.domain.usuario.controller.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public record UsuarioCadastroRequestDTO(
        String nomeCompleto,
        String email,
        String senha,
        String cpf,
        LocalDate dataNascimento) {

}
