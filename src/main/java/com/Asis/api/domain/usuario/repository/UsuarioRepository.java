package com.Asis.api.domain.usuario.repository;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

    UsuarioEntity findByCpf(String cpf);

}
