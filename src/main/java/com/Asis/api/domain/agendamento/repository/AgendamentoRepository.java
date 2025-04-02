package com.Asis.api.domain.agendamento.repository;

import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity,UUID> {
}
