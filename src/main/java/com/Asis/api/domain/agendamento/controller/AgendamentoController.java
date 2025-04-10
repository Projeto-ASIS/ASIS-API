package com.Asis.api.domain.agendamento.controller;

import com.Asis.api.domain.agendamento.controller.DTO.request.AgendamentoRequestDTO;
import com.Asis.api.domain.agendamento.controller.DTO.response.AgendamentosResponseDTO;
import com.Asis.api.domain.agendamento.entity.AgendamentoEntity;
import java.time.LocalDate;
import java.util.List;
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

    
    @PostMapping("/registrar/{id}")
    public ResponseEntity<String> agendar(@RequestBody AgendamentoRequestDTO request, @PathVariable String id) {

        agendamentoService.registraAgendamento(request, id);

        return ResponseEntity.status(HttpStatus.CREATED).body("Agendamento realizado com sucesso.");
    }



    @GetMapping
    public ResponseEntity<List<AgendamentosResponseDTO>> listarAgendamentos(
            @RequestParam LocalDate dataAtendimento,
            @RequestParam Integer unidadeId) {

        List<AgendamentoEntity> agendamentos = agendamentoService.buscaAgendamentos(dataAtendimento, (unidadeId));

        var response = AgendamentosResponseDTO.agendamentosToListResponseDTO(agendamentos);

        return ResponseEntity.ok(response);
    }

}