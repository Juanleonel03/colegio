package com.colegioprivado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegioprivado.models.UsuarioSistemaModel;

public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistemaModel, Long> {
    Optional<UsuarioSistemaModel> findByUsernameAndPassword(String username, String password);
}

