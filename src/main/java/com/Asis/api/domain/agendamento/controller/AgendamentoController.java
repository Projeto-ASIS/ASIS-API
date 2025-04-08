package com.Asis.api.domain.agendamento.controller;

import com.Asis.api.domain.agendamento.controller.DTOs.request.AgendamentoRequestDTO;
import com.Asis.api.domain.agendamento.controller.DTOs.response.AgendamentoResponseDTO;
import java.util.List;
import org.hibernate.annotations.Any;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Asis.api.domain.agendamento.service.AgendamentoService;
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

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> listarTodos() {
        List<AgendamentoResponseDTO> agendamentos = agendamentoService.buscarTodos();
        return ResponseEntity.ok(agendamentos);
    }

}