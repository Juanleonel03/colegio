package com.colegioprivado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioprivado.models.AsistenciaModel;

@Repository
public interface AsistenciaRepository extends JpaRepository<AsistenciaModel, Long> {}
