package com.Asis.api.domain.usuario.controller.DTOs;


import java.time.LocalDate;


public record UsuarioCadastroRequestDTO(
        String nomeCompleto,
        String email,
        String senha,
        String cpf,
        LocalDate dataNascimento) {

}
