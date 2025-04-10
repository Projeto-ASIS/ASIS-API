package com.Asis.api.domain.recuperarSenha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Asis.api.domain.recuperarSenha.entity.RedefinicaoDeSenhaEntity;

public interface TokenRedefinicaoDeSenhaRepository extends JpaRepository<RedefinicaoDeSenhaEntity, Long>{
    RedefinicaoDeSenhaEntity findByCodigo(String codigo);
}
