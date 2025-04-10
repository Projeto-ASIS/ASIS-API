package com.Asis.api.domain.servico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Asis.api.domain.servico.entity.ServicoEntity;
import com.Asis.api.domain.servico.repository.ServicoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;


    public List<ServicoEntity> servicos(){
        return servicoRepository.findAll();
    }

}
