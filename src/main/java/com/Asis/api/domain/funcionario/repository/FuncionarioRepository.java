package com.Asis.api.domain.funcionario.repository;

import com.Asis.api.domain.funcionario.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity,Long> {
}
