package com.Asis.api.domain.unidade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Asis.api.domain.unidade.entity.UnidadeSUASEntity;
import com.Asis.api.domain.unidade.repository.UnidadeSUASRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnidadeService {

    private final UnidadeSUASRepository unidadeSUASRepository;

    public List<UnidadeSUASEntity> findAll(){
        return unidadeSUASRepository.findAll();
    }

}
