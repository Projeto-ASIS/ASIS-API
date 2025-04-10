package com.Asis.api.domain.unidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Asis.api.domain.unidade.entity.UnidadeFuncionarioEntity;
import com.Asis.api.domain.unidade.entity.UnidadeFuncionarioId;

public interface UnidadeFuncionarioRepository extends JpaRepository<UnidadeFuncionarioEntity, UnidadeFuncionarioId>{

}
