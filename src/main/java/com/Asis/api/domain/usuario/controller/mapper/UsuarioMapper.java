package com.Asis.api.domain.usuario.controller.mapper;
import com.Asis.api.domain.usuario.controller.DTOs.request.UsuarioCadastroRequestDTO;
import com.Asis.api.domain.usuario.controller.DTOs.response.UsuarioDetailsResponseDTO;
import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    
    UsuarioEntity dtoToEntity(UsuarioCadastroRequestDTO usuarioCadastroRequestDTO);

    UsuarioDetailsResponseDTO toUsuarioDetailsResponseDTO(UsuarioEntity usuario);
}
