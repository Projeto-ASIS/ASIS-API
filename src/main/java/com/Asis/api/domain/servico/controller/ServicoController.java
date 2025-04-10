package com.Asis.api.domain.servico.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Asis.api.domain.servico.controller.DTO.response.ServicosResponseDTO;
import com.Asis.api.domain.servico.service.ServicoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    
    @GetMapping
    public ResponseEntity<List<ServicosResponseDTO>> servicos(){
        var servicos = servicoService.servicos();
        var response = ServicosResponseDTO.servicosToListResponseDTO(servicos);

        return ResponseEntity.ok(response);
    }
}   
