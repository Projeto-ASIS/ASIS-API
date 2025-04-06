package com.Asis.api.domain.agendamento.controller;

import org.hibernate.annotations.Any;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Asis.api.domain.agendamento.controller.DTOs.AgendamentoRequestDTO;
import com.Asis.api.domain.agendamento.service.AgendamentoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    
    @PostMapping("registrar/{id}")
    public ResponseEntity<Any> agendar(@RequestBody AgendamentoRequestDTO request, @PathVariable String id){

        agendamentoService.save(request, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
