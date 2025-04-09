package com.Asis.api.domain.agendamento.controller;

import com.Asis.api.domain.agendamento.controller.DTOs.request.AgendamentoRequestDTO;
import com.Asis.api.domain.agendamento.controller.DTOs.response.AgendamentosResponseDTO;
import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.Any;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Asis.api.domain.agendamento.service.AgendamentoService;
import com.Asis.api.utils.UtilsMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping("registrar/{id}")
    public ResponseEntity<Any> agendar(@RequestBody AgendamentoRequestDTO request, @PathVariable String id) {

        agendamentoService.save(request, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity<List<AgendamentosResponseDTO>> listarTodos(
            @RequestParam LocalDate dataAtendimento,
            @RequestParam Integer unidadeId) {

        List<AgendamentoEntity> agendamentos = agendamentoService.buscaAgendamentos(dataAtendimento, (unidadeId));
        var response = UtilsMapping.agendamentosToResponseDTO(agendamentos);
        return ResponseEntity.ok(response);
    }

}