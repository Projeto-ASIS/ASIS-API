package com.Asis.api.domain.usuario.controller.DTO.response;

import java.time.LocalDate;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;

public record UsuarioDetalhesResponseDTO(
    String nomeCompleto,
    String email,
    String role,
    LocalDate dataNascimento,
    String nis,
    String cadunico,
    String deficiencia,
    String cpf,
    String telefone1,
    String telefone2,
    String nomeMae
) {

    public UsuarioDetalhesResponseDTO(UsuarioEntity entity){
        this(
            entity.getNomeCompleto(),
            entity.getEmail(),
            entity.getRole().toString(),
            entity.getDataNascimento(),
            entity.getNis(),
            entity.getCadunico(),
            entity.getDeficiencia() != null ?entity.getDeficiencia().toString() :null,
            entity.getCpf(),
            entity.getTelefone1(),
            entity.getTelefone2(),
            entity.getNomeMae()
        );
    }
}
