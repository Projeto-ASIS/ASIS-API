package com.Asis.api.domain.usuario.repository;

import com.Asis.api.domain.usuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,String> {

    UserDetails findByCpf(String cpf);

    UsuarioEntity findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByNis(String nis);

    boolean existsByCadunico(String cadunico);

}
