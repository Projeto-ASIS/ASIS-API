package com.Asis.api.domain.agendamento.repository;

import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {

    boolean existsByDataAtendimentoAndFuncionario_id(LocalDate dataAtendimento, String id);

    List<AgendamentoEntity> findByDataAtendimentoAndUnidade_id(LocalDate dataAtendimento, Integer id);

}
