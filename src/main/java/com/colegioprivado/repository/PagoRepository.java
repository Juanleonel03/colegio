package com.colegioprivado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioprivado.models.PagoModel;

@Repository
public interface PagoRepository extends JpaRepository<PagoModel, Long> {}
