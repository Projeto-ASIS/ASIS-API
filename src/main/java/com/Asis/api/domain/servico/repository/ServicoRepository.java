package com.Asis.api.domain.servico.repository;

import com.Asis.api.domain.servico.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<ServicoEntity,Integer> {
}
