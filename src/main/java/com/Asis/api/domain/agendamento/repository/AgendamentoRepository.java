package com.Asis.api.domain.agendamento.repository;

import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity,Long> {

    boolean existsByDataAtendimentoAndUsuario_id(LocalDate dataAtendimento, String id);

}
