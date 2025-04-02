package com.Asis.api.domain.unidade.repository;

import com.Asis.api.domain.unidade.entity.UnidadeSUASEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeSUASRepository extends JpaRepository<UnidadeSUASEntity, UUID> {
}
