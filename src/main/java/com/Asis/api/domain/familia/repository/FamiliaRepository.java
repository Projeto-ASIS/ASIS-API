package com.Asis.api.domain.familia.repository;

import com.Asis.api.domain.familia.entity.FamiliaEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaRepository extends JpaRepository<FamiliaEntity, UUID> {
}
