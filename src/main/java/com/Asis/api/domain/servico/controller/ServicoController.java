package com.Asis.api.domain.servico.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Asis.api.domain.servico.controller.DTOs.response.ServicosResponseDTO;
import com.Asis.api.domain.servico.service.ServicoService;
import com.Asis.api.utils.UtilsMapping;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("servico")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<ServicosResponseDTO>> servicos(){
        var servicos = servicoService.servicos();
        var response = UtilsMapping.servicosToResponseDTO(servicos);

        return ResponseEntity.ok(response);
    }
}   
