package com.Asis.api.domain.endereco.repository;

import com.Asis.api.domain.endereco.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Long> {
}

