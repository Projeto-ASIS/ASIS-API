package com.Asis.api.domain.usuario.controller.DTO.request;


import java.time.LocalDate;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;


public record UsuarioCadastroRequestDTO(
        String nomeCompleto,
        String senha,
        String cpf,
        LocalDate dataNascimento) {

        public static UsuarioEntity toEntity(UsuarioCadastroRequestDTO dto){
                var entity = new UsuarioEntity();
                entity.setNomeCompleto(dto.nomeCompleto());
                entity.setCpf(dto.cpf());
                entity.setDataNascimento(dto.dataNascimento());
                return entity;
        }

}
