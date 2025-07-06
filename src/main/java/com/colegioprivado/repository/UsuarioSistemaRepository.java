package com.colegioprivado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.colegioprivado.models.UsuarioSistemaModel;

public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistemaModel, Long> {
    Optional<UsuarioSistemaModel> findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM UsuarioSistema WHERE correo = :correo", nativeQuery = true)
    List<UsuarioSistemaModel> findByCorreo(@Param("correo") String correo);
}

