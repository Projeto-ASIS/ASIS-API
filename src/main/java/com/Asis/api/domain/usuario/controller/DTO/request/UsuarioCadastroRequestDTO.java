package com.Asis.api.domain.usuario.controller.DTO.request;


import java.time.LocalDate;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;


public record UsuarioCadastroRequestDTO(
        String nomeCompleto,
        String senha,
        String cpf,
        String email,
        LocalDate dataNascimento) {

        public static UsuarioEntity toEntity(UsuarioCadastroRequestDTO dto){
                var entity = new UsuarioEntity();
                entity.setNomeCompleto(dto.nomeCompleto());
                entity.setSenha(dto.senha());
                entity.setCpf(dto.cpf());
                entity.setDataNascimento(dto.dataNascimento());
                entity.setEmail(dto.email());
                return entity;
        }

}
