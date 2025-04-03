package com.Asis.api.domain.usuario.repository;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,String> {

    Optional<UsuarioEntity> findById(String id);

    UserDetails findByCpf(String cpf);

}
