package com.colegioprivado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegioprivado.models.PerfilUsuarioModel;
import com.colegioprivado.models.UsuarioSistemaModel;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioModel, Long> {
    Optional<PerfilUsuarioModel> findByUsuario(UsuarioSistemaModel usuario);
}
