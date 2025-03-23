package com.Asis.api.domain.usuario.controller.mapper;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioCadastroRequestDTO;
import com.Asis.api.domain.usuario.controller.DTOs.UsuarioLoginResponseDTO;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioEntity dtoToEntity(UsuarioCadastroRequestDTO usuarioCadastroRequestDTO);
}
