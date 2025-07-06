package com.colegioprivado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioprivado.models.AdministradorModel;

@Repository 
public interface AdminRepository extends JpaRepository<AdministradorModel, Long>{}
