package com.Asis.api.domain.unidade.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Asis.api.domain.unidade.controller.DTO.response.UnidadeResponseDTO;
import com.Asis.api.domain.unidade.service.UnidadeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("unidades")
@RequiredArgsConstructor
public class UnidadeController {

    private final UnidadeService unidadeService;

    
    @GetMapping
    public ResponseEntity<List<UnidadeResponseDTO>> findAll(){
        
        var unidades = unidadeService.findAll();

        var response = UnidadeResponseDTO.unidadesToListResponseDTO(unidades);

        return ResponseEntity.ok(response);
    }
}
